<!--The Qizz Login Page-->
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
                background-color: lavender;
                font-family: Arial, Helvetica, sans-serif;
            }
            .block{
                width: auto;
                padding: 15px;
                margin-top: 10px;
                background-color: white;
                border-radius: 10px;
            }
            input[type="submit"]{
                background-color: darkmagenta;
                padding:8px 16px;
                cursor: pointer;
                color:white;
            }
            input[type="reset"]{
                transform:translate(1200px);
            }
        </style>
    </head>
    <body>
            <%
            HttpSession mySession=request.getSession(true);
            if("POST".equalsIgnoreCase(request.getMethod())){
                String enterUsername=request.getParameter("Username");
                String enterEmail=request.getParameter("Email");
                String enterEnrollmentno=request.getParameter("Enrollnumber");
                
                mySession.setAttribute("userName",enterUsername);
                mySession.setAttribute("email",enterEmail);
                mySession.setAttribute("Enrollno",enterEnrollmentno);
                response.sendRedirect("Qizz.jsp");
                return;
            }
            %>
            <form action="LoginPage.jsp" method="POST">
                <div class="block">
                    <label for="Username">NAME OF STUDENT*</label><br><br>
                        <input type="text" id="Username" name="Username" placeholder="Your answer" required/>
                </div>

                <div class="block">
                    <label for="Email">EMAIL*</label><br><br>
                    <input type="email" id="Email" name="Email" placeholder="Your answer" required/>
                </div>

                <div class="block">
                    <label for="Enrollnumber">ENROLLMENT NO*</label><br><br>
                    <input type="text" id="Enrollnumber" name="Enrollnumber" placeholder="Your answer" required/>
                </div>
                <br>
                <input type="submit" value="Next" />
                <input type="reset" value="Clear form" /> 
            </form><br>
        <p style="font-size: 12px;">Never submit password through Google Forms.</p>
        <p style="font-size: 12px;">@?Does this form look suspicious?Report</p>
    </body>
</html>

