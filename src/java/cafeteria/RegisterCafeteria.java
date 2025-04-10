/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cafeteria;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterCafeteria", urlPatterns = {"/cafeteria/RegisterCafeteria"})
public class RegisterCafeteria extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        
    }   
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone_no = request.getParameter("phoneNo");
        String nationalID = request.getParameter("nationalID");
        String cafeteria = request.getParameter("cafeteria");
        String password = request.getParameter("password");
        
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO users (first_name, last_name, username, phone_number, national_id, password, is_cafe_staff) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, lastName.toLowerCase() + "" + firstName.toLowerCase());
            stmt.setString(4, phone_no);
            stmt.setString(5, nationalID);
            stmt.setString(6, password);
            stmt.setBoolean(7, true);
            stmt.executeUpdate();
            conn.close();
        }     catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }

          int user_id = 0;
          try {
            Connection conn = DBConnection.getConnection();
            //query to get data from db
            String sql = "SELECT user_id FROM users WHERE national_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nationalID);
            //Hii ni kama array in a contain hiyo information
            ResultSet rs = stmt.executeQuery();
            
            //Loops through the array and stores user id in variable
            while (rs.next()) {
                user_id = rs.getInt("user_id");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
          
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO cafeterias (cafeteria_name, user_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            //Kuwa conscious of the data type "setString" "setInt"
            stmt.setString(1, cafeteria);
            stmt.setInt(2, user_id);
            stmt.executeUpdate();
            conn.close();
        }     catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
        
        response.sendRedirect("home?cafeteria=" + cafeteria);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
