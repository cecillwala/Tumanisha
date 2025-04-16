
package cafeteria;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.Hash;
import Query.Cafeteria;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cecillwala
 */
@WebServlet(name = "LoginCafeteria", urlPatterns = {"/cafeteria/login"})
public class LoginCafeteria extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        String cafeteria = request.getParameter("cafeteria");
        String password = Hash.hashPassword(request.getParameter("password"));
        
        String hashed= "";
        try {
            hashed = Cafeteria.getCafeteriaPassword(cafeteria);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCafeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (password.equals(hashed)) {
            response.sendRedirect("HomeCafeteria?cafeteria=" + cafeteria.toLowerCase());
        } else {
            
        }
        
        response.sendRedirect("HomeCafeteria?cafeteria=" + cafeteria.toLowerCase());
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
