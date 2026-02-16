<!-- Registration Page For User -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Registration Page Of User
        </title>
    </head>
    <body>
        <%
        HttpSession mySession=request.getSession(true);
        String enterUsername=(String)mySession.getAttribute("userName");
        String enterEmail=(String)mySession.getAttribute("email");
        String enterPassword=(String)mySession.getAttribute("password");
        if(enterUsername != null && enterEmail != null && enterPassword != null){
            final String url="jdbc:mysql://127.0.0.1:3306/Car";
            final String dbusername="root";
            final String dbpassword="9689";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch(ClassNotFoundException e){
                out.println(e.getMessage());
            }
            String query="INSERT INTO registerInformation(name,email,password) VALUES(?,?,?)";
            try(Connection connection=DriverManager.getConnection(url,dbusername,dbpassword);
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
                connection.setAutoCommit(false);
                preparedStatement.setString(1,enterUsername);
                preparedStatement.setString(2,enterEmail);
                preparedStatement.setString(3,enterPassword);
                int rowsAffected=preparedStatement.executeUpdate();
                if(rowsAffected > 0){
                    connection.commit();
                }
                preparedStatement.close();
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            %><meta http-equiv="refresh" content="0.01;URL=Items.jsp">
            <%
        }
        else{
            response.sendRedirect("Login.jsp");
            return;
        }
        %>
    </body>
</html>
