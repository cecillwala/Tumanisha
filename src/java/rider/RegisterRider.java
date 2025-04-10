/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package rider;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



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
        String nationalID = request.getParameter("nationalID");
        String gmail = request.getParameter("gmail");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");

         response.sendRedirect("home.jsp");

        
    }

    

}
