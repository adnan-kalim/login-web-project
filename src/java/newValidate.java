/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adnan
 */
import java.io.*;
import javax.servlet.http.*; // For HttpServlet
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

public class newValidate extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {      
        String name = req.getParameter("id");
        String pass = req.getParameter("pass");
        
        if(name.equals("adnan") && pass.equals("dubai12"))
        {
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            res.sendRedirect("Welcome");
        }
        
    }
}
