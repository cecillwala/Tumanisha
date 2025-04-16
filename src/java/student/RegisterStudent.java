/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package student;

import Query.User;
import Query.Student;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



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
        String regNo = request.getParameter("regNo");
        String password = request.getParameter("password");
        String hostel = request.getParameter("hostel");
        String roomNumber = request.getParameter("roomNumber");
        
        User user = new User(firstName, lastName, lastName.toLowerCase() + "" + firstName.toLowerCase(), phone_no, password, nationalID, true, false, false);
        try {
            User.addUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            user = User.getUserById(nationalID);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        Student student = new Student(regNo, user.userId, hostel, roomNumber);
        
        try {
            Student.addStudent(student);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("user", user);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeStudent");
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
