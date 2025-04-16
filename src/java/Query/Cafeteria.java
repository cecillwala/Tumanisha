/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;

/**
 *
 * @author cecillwala
 */
public class Cafeteria {
    
    public int cafeteriaId;
    public String name;
    public String imageUrl;
    public int userId;
    
    
    
    public Cafeteria(int cafeteriaId, String name, String imageUrl, int userId) {
        this.cafeteriaId = cafeteriaId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.userId = userId;
    }

    
    public static void addCafeteria(Cafeteria cafeteria) throws SQLException {
        String sql = "INSERT INTO cafeteria (cafeteria_name, image_url, user_id) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cafeteria.name);
            stmt.setString(2, cafeteria.imageUrl);
            stmt.setInt(3, cafeteria.userId);
            stmt.executeUpdate();
        }
    }



    public static List<Cafeteria> getCafeterias() throws SQLException {
        List<Cafeteria> cafeterias = new ArrayList<>();
        String sql = "SELECT * FROM cafeterias";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cafeteria cafeteria = new Cafeteria(rs.getInt("cafeteria_id"), rs.getString("cafeteria_name"), rs.getString("image_url"), rs.getInt("user_id"));
                cafeterias.add(cafeteria);
            }
        }
        return cafeterias;
    }
    
    
    public static String getCafeteriaPassword(String cafeteria) throws SQLException {
        String password = "";
        String sql = "SELECT password FROM cafeterias WHERE cafeteria = ?";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cafeteria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        }
        return password;
    }

}


