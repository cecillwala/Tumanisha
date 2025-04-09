/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package student;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//DB packages
import database.DBConnection;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author cecillwala
 */
@WebServlet(name = "RegisterStudent", urlPatterns = {"/RegisterStudent"})
public class RegisterStudent extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone_no = request.getParameter("phoneNo");
        String nationalID = request.getParameter("nationalID");
        String studentId = request.getParameter("studentId");
        String password = request.getParameter("password");
        
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO users (first_name, last_name, username, phone_number, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, lastName.toLowerCase() + "" + firstName.toLowerCase());
            stmt.setString(4, phone_no);
            stmt.setString(5, password);
            stmt.executeUpdate();
            conn.close();
            
            String url = "student/home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }     catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
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
