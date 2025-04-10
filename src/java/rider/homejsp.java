/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(name = "homejsp", urlPatterns = {"/rider/homejsp"})
public class homejsp extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("open".equals(action)) {
            // Simulate order assignment. In a real app, pull order details from a database.
            String orderDetails = "OrderID: 12345 - Pickup at Location A, Deliver to Location B.";
            session.setAttribute("order", orderDetails);
            // Redirect back to home.jsp to display the order
            response.sendRedirect("home.jsp");
        } else if ("accept".equals(action)) {
            // Simulate order acceptance
            String orderId = "12345"; // In a real app, you would extract the order ID from the order data.
            session.removeAttribute("order");
            // Redirect to a simple order page
            response.sendRedirect("order.jsp?orderId=" + orderId);
        }
        
    }
     // For convenience, redirect GET requests to home.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home.jsp");
    }
}
