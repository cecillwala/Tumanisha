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
import java.sql.Connection;
import java.sql.PreparedStatement;


@WebServlet(name = "RegisterRider", urlPatterns = {"/rider/RegisterRider"})
public class RegisterRider extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //TODO
   
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String gmail = request.getParameter("gmail");
        String confirmPassword = request.getParameter("confirm");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO users ( first_name, last_name,  password, gmail) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
  
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, password);
            stmt.setString(4, gmail);
            stmt.executeUpdate();
            conn.close();
            
            String url = "rider/home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }     catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
    }

    

}
