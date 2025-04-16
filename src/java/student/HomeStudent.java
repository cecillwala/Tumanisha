/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package student;

import Query.User;
import Query.Cafeteria;
import Query.Student;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cecillwala
 */
@WebServlet(name = "HomeStudent", urlPatterns = {"/HomeStudent"})
public class HomeStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cafeteria> cafeterias = new ArrayList();    
        try {
            cafeterias = Cafeteria.getCafeterias();
        } catch (SQLException ex) {
            Logger.getLogger(HomeStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("cafeterias", cafeterias);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/home.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Cafeteria> cafeterias = new ArrayList();
            
        try {
            cafeterias = Cafeteria.getCafeterias();
        } catch (SQLException ex) {
            Logger.getLogger(HomeStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
            User user = (User) request.getAttribute("user");
            Student student = (Student) request.getAttribute("student");
            request.setAttribute("user", user);
            request.setAttribute("cafeterias", cafeterias);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/home.jsp");
            dispatcher.forward(request, response);
            
            
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
