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
import java.sql.*;

public class Validate extends HttpServlet        
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        String name = req.getParameter("id");
        String pass = req.getParameter("pass");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        PreparedStatement ps = null;
       
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "select * from loginInfo where userid = '" + name + "' and password = '" + pass + "' ;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                
                HttpSession session = req.getSession();
                session.setAttribute("user", name);
                session.setAttribute("pass",pass);
                res.sendRedirect("userDetails.jsp");
            }
            else
            {
                out.println("Wrong Password !");
            }
            
            ps.close();
            con.close();
        }
        catch(SQLException se)
        {            
            out.println(se);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      
    }
}
