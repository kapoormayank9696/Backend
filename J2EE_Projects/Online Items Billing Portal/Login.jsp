<!-- User Login Page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Login Page
        </title>
        <style>
            body{
                font-family: Arial, Helvetica, sans-serif;
                background-color: lightblue;
                color: white;
            }
            .container{
                text-align: center;
                width: auto;
                max-width: 400px;
                padding: 56px;
                background-color: darkseagreen;
                color: white;
                border-radius: 35px;
                transform: translate(400px, 60px);
                border:solid;
            }
            label{
                display:block;
                margin-top: 15px;
            }
            input[type="text"],
            input[type="email"],
            input[type="password"]{
                font-size: 16px;
                width:59%;
                padding:8px;
                border-radius: 15px;
            }
            input[type="submit"]{
                margin-top: 15px;
                background-color: wheat;
                padding: 3px;
                width: 200px;
                border-radius: 15px;
                font-weight: bold;
                text-align: center;
                border:solid;
                cursor: pointer;
                font-size: 16px;
            }
        </style>
    </head>
    <body>
        <%
        HttpSession mySession=request.getSession(true);
        if(request.getMethod().equalsIgnoreCase("POST")){
            String enteredUsername=request.getParameter("Username");
            String enteredEmail=request.getParameter("Email");
            String enteredPassword=request.getParameter("Password");
            
            mySession.setAttribute("userName",enteredUsername);
            mySession.setAttribute("email",enteredEmail);
            mySession.setAttribute("password",enteredPassword);
            response.sendRedirect("Register.jsp");
            return;
        }
        %>
        <form action="Login.jsp" method="POST">
            <div class="container">
                    <h1 style="text-align:center;">Login</h1>
                <label for="userName">Username * 
                    <input type="text" id="userName" name="Username" placeholder="Your Username" required/><br>
                </label>
                <label for="email">Email * 
                    <input type="Email" id="email" name="Email" placeholder="Your Email" required/><br>
                </label>
                <label for="password">Password * 
                    <input type="password" id="password" name="Password" placeholder="Your Password" required/><br><br>
                </label>
                <input type="submit" value="Create" />
            </div>
        </form>
    </body>
</html>

