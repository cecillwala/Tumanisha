/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package rider;

import database.DBConnection;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author cecillwala
 */
@WebServlet(name = "LoginRider", urlPatterns = {"/rider/LoginRider"})
public class LoginRider extends HttpServlet {
    
     private static final Logger LOGGER = Logger.getLogger(LoginRider.class.getName());

    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        // Forward to login page
        request.getRequestDispatcher("rider/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
          // 1. Get login form input
        String userName = request.getParameter("userName"); // field name from the form
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()) {
            out.println("<script>alert('❌ Username or password is missing.'); window.history.back();</script>");
            return;
    }
     try { 
         Connection conn = DBConnection.getConnection();

            // 2. Check if user exists and password matches
            String sql = "SELECT * FROM users WHERE usserName = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, password); 

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // ✅ Success: Create session
                HttpSession session = request.getSession(true);
                session.setAttribute("riderName", rs.getString("first_name") + " " + rs.getString("last_name"));
                session.setAttribute("riderId", rs.getInt("id"));

                // Redirect to home page
                response.sendRedirect("rider/home.jsp");

            } else {
                // ❌ Invalid credentials
                request.setAttribute("errorMessage", "Invalid ID or password.");
                request.getRequestDispatcher("rider/login.html").forward(request, response);
            }

            }catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Login error: ", e);
            out.println("<script>alert('❌ An error occurred while processing your login.'); window.history.back();</script>");
           
        
        }

   
    } 
}
