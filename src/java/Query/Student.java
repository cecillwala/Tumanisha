/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import java.sql.*;
import database.DBConnection;

/**
 *
 * @author cecillwala
 */
public class Student {
    public int studentId;
    public String regNo;
    public int userId;
    public String hostel;
    public String roomNumber;
    
    public Student(){
        this.studentId = 0;
        this.regNo = "";
        this.userId = 0;
        this.hostel = "";
        this.roomNumber = "";
    }
    
    public Student( int studentId, String regNo, int userId, String hostel, String roomNumber){
        this.studentId = studentId;
        this.regNo = regNo;
        this.userId = userId;
        this.hostel = hostel;
        this.roomNumber = roomNumber;
    }
    
     public Student(String regNo, int userId, String hostel, String roomNumber){
        this.regNo = regNo;
        this.userId = userId;
        this.hostel = hostel;
        this.roomNumber = roomNumber;
    }
    
    public static void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (user_id, hostel, room_number, reg_no) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, student.userId);
            stmt.setString(2, student.hostel);
            stmt.setString(3, student.roomNumber);
            stmt.setString(4, student.regNo);
            stmt.executeUpdate();
        }
    }

    public Student getStudentById(String regNo) throws SQLException {
        String sql = "SELECT * FROM students WHERE reg_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, regNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt("student_id"), regNo, rs.getInt("user_id"), rs.getString("hostel"), rs.getString("room_number"));
                return student;
            }
        }
        return null;
    }
    
    
    public static String getStudentPassword(String reg_no) throws SQLException {
        String password = "";
        String sql = "SELECT password FROM students WHERE reg_no = ?";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, reg_no);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        }
        return password;
    }
}
