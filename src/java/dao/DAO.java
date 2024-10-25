/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Food;
import model.Location;
import model.Restaurant;
import model.ReviewFood;
import model.ReviewRestaurant;

/**
 *
 * @author SHD
 */
public class DAO extends DBContext {

    public boolean isUsernameTaken(String username) {
        String sql = "SELECT COUNT(*) FROM Account WHERE username = ?";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Food getFoodById(int foodId) {
        Food food = null;
        String query = "SELECT * FROM Food WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, foodId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                food = new Food(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("restaurant_id"),
                        rs.getString("detail"),
                        rs.getInt("price"),
                        rs.getInt("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    public List<Food> getFoodsByRestaurantId(int restaurantId) {
        List<Food> foodList = new ArrayList<>();
        String query = "SELECT * FROM Food WHERE restaurant_id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Food food = new Food(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("restaurant_id"),
                        rs.getString("detail"),
                        rs.getInt("price"),
                        rs.getInt("status")
                );
                foodList.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodList;
    }

    // Method to update food item status
    public void updateFoodStatus(int foodId, int status) {
        String query = "UPDATE Food SET status = ? WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, status);
            ps.setInt(2, foodId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new food item
    public void addFood(Food food) {
        String query = "INSERT INTO Food (name, image, restaurant_id, detail, price, status) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, food.getName());
            ps.setString(2, food.getImage());
            ps.setInt(3, food.getRestaurant_id());
            ps.setString(4, food.getDetail());
            ps.setInt(5, food.getPrice());
            ps.setInt(6, food.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update food item details
    public void updateFood(Food food) {
        String query = "UPDATE Food SET name = ?, image = ?, detail = ?, price = ?, status = ? WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, food.getName());
            ps.setString(2, food.getImage());
            ps.setString(3, food.getDetail());
            ps.setInt(4, food.getPrice());
            ps.setInt(5, food.getStatus());
            ps.setInt(6, food.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getRestaurantsByOwner(int ownerId, int page, int pageSize) {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM Restaurant WHERE owner_id = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (
                 PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ownerId);
            ps.setInt(2, (page - 1) * pageSize); // Offset
            ps.setInt(3, pageSize);              // Fetch next
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("address"), rs.getString("phone"),
                        rs.getString("image"), rs.getString("detail"),
                        rs.getInt("cate_id"), rs.getInt("status"),
                        rs.getInt("location_id")
                );
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public int getTotalRestaurantsByOwner(int ownerId) {
        String query = "SELECT COUNT(*) FROM Restaurant WHERE owner_id = ?";
        try (
                 PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Register new account
    public boolean register(Account account) {
        if (isUsernameTaken(account.getUsername())) {
            return false; // Username is already taken
        }
        String sql = "INSERT INTO Account (username, password, phone, address, fullname,role,status) VALUES (?, ?, ?, ?, ?,0,1)";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getPhone());
            ps.setString(4, account.getAddress());
            ps.setString(5, account.getFullname());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Restaurant> getRestaurants(int cate_id, int location_id, String search, int page, int pageSize) {
        List<Restaurant> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Restaurant WHERE 1=1 ";
            if (cate_id != 0) {
                sql += " AND cate_id = ?";
            }
            if (location_id != 0) {
                sql += " AND location_id = ?";
            }
            if (search != null && !search.trim().isEmpty()) {
                sql += " AND name LIKE ?";
            }
            // Using OFFSET and FETCH NEXT for SQL Server pagination
            sql += " ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

            PreparedStatement ps = connection.prepareStatement(sql);
            int paramIndex = 1;
            if (cate_id != 0) {
                ps.setInt(paramIndex++, cate_id);
            }
            if (location_id != 0) {
                ps.setInt(paramIndex++, location_id);
            }
            if (search != null && !search.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + search + "%");
            }
            ps.setInt(paramIndex++, (page - 1) * pageSize);  // OFFSET
            ps.setInt(paramIndex, pageSize);  // FETCH NEXT

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaurant r = new Restaurant(rs.getInt("id"), rs.getString("name"),
                        rs.getString("address"), rs.getString("phone"),
                        rs.getString("image"), rs.getString("detail"),
                        rs.getInt("cate_id"), rs.getInt("status"), rs.getInt("location_id"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
         Restaurant restaurant = new Restaurant();
        restaurant.setName("Monarque Hotel Vip");
        restaurant.setImage("https://pix10.agoda.net/hotelImages/2613181/-1/6f1bb8a2c136eb9bb293b2ea7b8b3627.jpg?ca=17&ce=1&s=414x232&ar=16x9");
        restaurant.setAddress("238 Võ Nguyên Giáp, Phước Mỹ");
        restaurant.setPhone("0123456789");
        restaurant.setCate_id(3);
        restaurant.setLocation_id(3);
        restaurant.setDetail("o");
        new DAO().updateRestaurant(restaurant);
    }

    public int countRestaurants(int cate_id, int location_id, String search) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM Restaurant WHERE 1=1 ";
            if (cate_id != 0) {
                sql += " AND cate_id = ?";
            }
            if (location_id != 0) {
                sql += " AND location_id = ?";
            }
            if (search != null && !search.trim().isEmpty()) {
                sql += " AND name LIKE ?";
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            int paramIndex = 1;
            if (cate_id != 0) {
                ps.setInt(paramIndex++, cate_id);
            }
            if (location_id != 0) {
                ps.setInt(paramIndex++, location_id);
            }
            if (search != null && !search.trim().isEmpty()) {
                ps.setString(paramIndex, "%" + search + "%");
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                list.add(category);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public void addRestaurant(Restaurant restaurant, int ownerId) {
        String sql = "INSERT INTO Restaurant (name, image, address, phone, detail, cate_id, location_id, owner_id, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getImage());
            stmt.setString(3, restaurant.getAddress());
            stmt.setString(4, restaurant.getPhone());
            stmt.setString(5, restaurant.getDetail());
            stmt.setInt(6, restaurant.getCate_id());
            stmt.setInt(7, restaurant.getLocation_id());
            stmt.setInt(8, ownerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET name = ?, image = ?, address = ?, phone = ?, detail = ?, cate_id = ?, location_id = ? WHERE id = ?";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getImage());
            stmt.setString(3, restaurant.getAddress());
            stmt.setString(4, restaurant.getPhone());
            stmt.setString(5, restaurant.getDetail());
            stmt.setInt(6, restaurant.getCate_id());
            stmt.setInt(7, restaurant.getLocation_id());
            stmt.setInt(8, restaurant.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public List<Location> getAllLocation() {
        List<Location> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Location";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Location location = new Location(rs.getInt(1), rs.getString(2));
                list.add(location);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public List<Restaurant> getAllRestaurant(int cate_id) {
        List<Restaurant> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Restaurant where status = 1 and cate_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cate_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                restaurant.setNumberComment(new DAO().getTotalComment(restaurant.getId()));
                restaurant.setRating(new DAO().getRating(restaurant.getId()));
                list.add(restaurant);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public List<Food> getAllFoodInRestaurant(int rest_id) {
        List<Food> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Food where status = 1 and restaurant_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rest_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Food food = new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                list.add(food);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public List<ReviewRestaurant> getAllReviewRestaurant(int rest_id) {
        List<ReviewRestaurant> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [ReviewRestaurant] where restaurant_id = ? order by createDate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rest_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ReviewRestaurant review = new ReviewRestaurant(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                list.add(review);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public List<ReviewFood> getAllReviewFood(int food_id) {
        List<ReviewFood> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [ReviewFood] where food_id = ? order by createDate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, food_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ReviewFood review = new ReviewFood(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                list.add(review);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public Category getCategory(int cate_id) {
        try {
            String sql = "SELECT * FROM Category where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cate_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));

            }
        } catch (Exception ex) {

        }
        return null;
    }

    public Account getAccount(int acc_id) {
        try {
            String sql = "SELECT * FROM Account where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, acc_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));

            }
        } catch (Exception ex) {

        }
        return null;
    }

    public Restaurant getRestaurant(int id) {
        try {
            String sql = "SELECT * FROM Restaurant where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant r = new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                r.setNumberComment(new DAO().getTotalComment(r.getId()));
                r.setRating(new DAO().getRating(r.getId()));
                return r;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public int getRating(int id) {
        int total = 0;
        try {

            String sql = "select sum(rating) from ReviewRestaurant where restaurant_id = ? group by restaurant_id;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);

            }
        } catch (Exception ex) {

        }
        if (new DAO().getTotalComment(id) > 0) {
            total = (int) (total / new DAO().getTotalComment(id));
        }
        return total;
    }

    public int getTotalComment(int id) {
        int total = 0;
        try {
            String sql = "select count(*) from ReviewRestaurant where restaurant_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);

            }
        } catch (Exception ex) {

        }
        return total;
    }

    public Food getFood(int id) {
        try {
            String sql = "SELECT * FROM Food where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Food r = new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                r.setNumberComment(new DAO().getTotalCommentFood(r.getId()));
                r.setRating(new DAO().getRatingFood(r.getId()));
                return r;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public int getRatingFood(int id) {
        int total = 0;
        try {

            String sql = "select sum(rating) from ReviewFood where food_id = ? group by food_id;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);

            }
        } catch (Exception ex) {

        }
        if (new DAO().getTotalComment(id) > 0) {
            total = (int) (total / new DAO().getTotalCommentFood(id));
        }
        return total;
    }

    public int getTotalCommentFood(int id) {
        int total = 0;
        try {
            String sql = "select count(*) from ReviewFood where food_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);

            }
        } catch (Exception ex) {

        }
        return total;
    }

    public List<Account> getAccountsByRole() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Account WHERE role IN (0, 2)";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("image"),
                        rs.getString("phone"),
                        rs.getInt("role"),
                        rs.getString("address"),
                        rs.getString("fullname"),
                        rs.getInt("status")
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Toggle account status between 0 and 1
    public boolean toggleAccountStatus(int accountId) {
        String sql = "UPDATE Account SET status = CASE WHEN status = 1 THEN 0 ELSE 1 END WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account getAccount(String username, String password) {
        try {
            String sql = "SELECT * FROM Account where username like ? and password like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public void addRvRestaurant(int rest_id, String content, int rating, int id) {
        try {
            String sql = "INSERT INTO [dbo].[ReviewRestaurant]\n"
                    + "           ([rating]\n"
                    + "           ,[comment]\n"
                    + "           ,[restaurant_id]\n"
                    + "           ,[account_id]\n"
                    + "           ,[createDate])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,GETDATE())";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rating);
            stm.setString(2, content);
            stm.setInt(3, rest_id);
            stm.setInt(4, id);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void updateRvRestaurant(String content, int rating, int id) {
        try {
            String sql = "UPDATE [dbo].[ReviewRestaurant]\n"
                    + "   SET [rating] = ?\n"
                    + "      ,[comment] = ?\n"
                    + "      ,[createDate] = GETDATE()\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rating);
            stm.setString(2, content);
            stm.setInt(3, id);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void removeRvRestaurant(int id) {
        try {
            String sql = "DELETE FROM [dbo].[ReviewRestaurant]\n"
                    + "      WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }
}
