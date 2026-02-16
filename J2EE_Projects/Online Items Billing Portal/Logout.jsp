<!-- Logout By The User -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Logout Page
        </title>
        <style>
            body{
                font-family: Arial, Helvetica, sans-serif;
                background-color: lightblue;
                color: white;
            }
            .container{
                background-color: darkseagreen;
                color:white;
                max-width: 400px;
                transform: translate(450px,80px);
                border: solid;
                border-radius: 35px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center;">Logout</h1>
            <%
            HttpSession mySession=request.getSession(false);
            if(mySession != null){
                mySession.invalidate();
            }
            %>
            <p style="text-align: center;">You have been successfully logout</p>
            <p style="text-align: center;"><a href="Login.jsp">Again Login</a></p>
            <meta http-equiv="refresh" content="3;URL=Login.jsp">
        </div>
    </body>
</html>

