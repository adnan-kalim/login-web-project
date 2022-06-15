/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adnan
 */
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

public class forgot extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter out = res.getWriter();
        out.println("Please click here to reset password ");
    }
}
