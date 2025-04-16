package cafeteria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;

import Query.MenuItem;

/**
 *
 * @author cecillwala
 */
@WebServlet(urlPatterns = {"/cafeteria/HomeCafeteria"})
public class HomeCafeteria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        List<MenuItem> menuItems = new ArrayList<>();
        String cafeteria = request.getParameter("cafeteria");
        menuItems = MenuItem.getAllMenuItems(cafeteria);
        
        for(MenuItem item : menuItems ){
            System.out.println(item.item);
        }
        
        request.setAttribute("menuItems", menuItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cafeteria/home.jsp");
        dispatcher.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
