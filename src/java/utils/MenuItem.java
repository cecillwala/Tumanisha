package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;


public class MenuItem {
    
    public int menu_id;
    public String item;
    public double price;
    public double stock_quantity;
    public int cafeteria_id;
    public boolean is_available;
    public String image_url;

    public MenuItem(int menu_id, String item, double price, double stock_quantity,int cafeteria_id, boolean is_available, String image_url) {
        this.menu_id = menu_id;
        this.item = item;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.cafeteria_id = cafeteria_id;
        this.is_available = is_available;
        this.image_url = image_url;
    }

    // Get all menu items from the database
    public static List<MenuItem> getAllMenuItems(int id) {
        List<MenuItem> menuItems = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM menu WHERE cafeteria_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("menu_id"),
                    rs.getString("item"),
                    rs.getInt("price"),
                    rs.getDouble("stock_quantity"),
                    rs.getInt("cafeteria_id"),
                    rs.getBoolean("is_available"),
                    rs.getString("image_url")
                );
                menuItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    // Add a new menu item to the database
    public static void addMenuItem(MenuItem item, int cafeteria_id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO menu_items (image_url, name, amount, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.image_url);
            stmt.setString(2, item.item);
            stmt.setDouble(3, item.stock_quantity);
            stmt.setDouble(4, item.price);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a menu item from the database
    public static void deleteMenuItem(int itemId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM menu_items WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    // Update a menu item in the database
//    public static void updateMenuItem(MenuItem item) {
//        try (Connection conn = DBConnection.getConnection()) {
//            String sql = "UPDATE menu_items SET image_url = ?, name = ?, amount = ?, price = ? WHERE id = ?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, item.imageUrl);
//            stmt.setString(2, item.name);
//            stmt.setInt(3, item.amount);
//            stmt.setDouble(4, item.price);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
