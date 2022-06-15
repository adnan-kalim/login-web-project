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
import java.sql.*;
import java.util.Random;

public class forgotServlet extends HttpServlet    
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        String name = req.getParameter("username");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String otp = String.format("%06d", number);       
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "insert into forgot values (?,?);";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, otp);
            out.println(ps);
            int num = ps.executeUpdate();
            
            out.println(num + " rows affected");
                      
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
               
        HttpSession session = req.getSession();
        session.setAttribute("otp", otp);
        res.sendRedirect("getOTP.jsp");
    }
}
