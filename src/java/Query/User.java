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
public class User {
    public int userId;
    public String firstName;
    public String lastName;
    public String username;
    public String phoneNumber;
    public String password;
    public String nationalId;
    public boolean isCafeStaff;
    public boolean isRider;
    public boolean isStudent;
    
    public User(int userId, String firstName, String lastName, String username, String phoneNumber, String password, String nationalId, boolean isStudent, boolean isCafeStaff, boolean isRider){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationalId = nationalId;
        this.isStudent = isStudent;
        this.isCafeStaff = isCafeStaff;
        this.isRider = isRider;
    }
    
    public User(String firstName, String lastName, String username, String phoneNumber, String password, String nationalId, boolean isStudent, boolean isCafeStaff, boolean isRider){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationalId = nationalId;
        this.isStudent = isStudent;
        this.isCafeStaff = isCafeStaff;
        this.isRider = isRider;
    }
    
    public static void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, username, phone_number, password, national_id, is_student, is_cafe_staff, is_rider) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, user.firstName);
            stmt.setString(2, user.lastName);
            stmt.setString(3, user.lastName.toLowerCase() + "" + user.firstName.toLowerCase());
            stmt.setString(4, user.phoneNumber);
            stmt.setString(5, user.password);
            stmt.setString(6, user.nationalId);
            stmt.setBoolean(7, user.isStudent);
            stmt.setBoolean(8, user.isCafeStaff);
            stmt.setBoolean(9, user.isRider);

            stmt.executeUpdate();
        }
    }

    public static User getUserById(String Id) throws SQLException {
        String sql = "SELECT * FROM users WHERE national_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getString("phone_number"), rs.getString("password"), rs.getString("national_id"), rs.getBoolean("is_student"), rs.getBoolean("is_cafe_staff"), rs.getBoolean("is_rider"));
                return user;
            }
        }
        return null;
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getString("phone_number"), rs.getString("password"), rs.getString("national_id"), rs.getBoolean("is_student"), rs.getBoolean("is_cafe_staff"), rs.getBoolean("is_rider"));
                users.add(user);
            }
        }
        return users;
    }
}
