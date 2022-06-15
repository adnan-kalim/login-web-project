<%-- 
    Document   : getOTP
    Created on : 14 Jun 2022, 12:39:45 PM
    Author     : adnan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
    </head>
    <body>
        
        <% String otp = (String) session.getAttribute("otp");
        %>
        
        <h1>Enter OTP</h1>
        
        <form action="checkOTP" method="post">
            Enter your OTP <input type="text" name="auth"><br><!-- comment -->
            <input type="submit"> 
        </form>
        
        <p> Your OTP is <% out.println(otp); %> </p>  
        
    </body>
</html>
