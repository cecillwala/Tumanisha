/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class DBConnection {
    static String db_URL = "jdbc:mysql://localhost:3306/tumanisha_db";
    static String db_user = "root";
    static String db_pasuwad = "root";
    
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(db_URL, db_user, db_pasuwad);
        }
        catch(ClassNotFoundException e){
            throw new SQLException("MySQL JDC driver not found!", e);
        }
    }
}
