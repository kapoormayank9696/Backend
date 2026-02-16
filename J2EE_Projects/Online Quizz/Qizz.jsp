<!-- Quizz Question Page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Quizz Question Print
        </title>
        <style>
            body{
                background-color: lavender;
                font-family: Arial, Helvetica, sans-serif;
            }
            .block{
                background-color: white;
                border-radius: 10px;
                width: auto;
                padding: 15px;
                margin-top: 10px;
            }
            input[type="radio"]{
                margin-top: 10px;
            }
            input[type="submit"]{
                background-color: darkmagenta;
                padding: 8px 16px;
                cursor: pointer;
                color: white;
            }
           input[type="reset"]{
            transform:translate(1175px);
        }
        </style>
    </head>
    <body>
        <%
        HttpSession mySession=request.getSession(true);
        String userName=(String)mySession.getAttribute("userName");
        String email=(String)mySession.getAttribute("email");
        String enrollno=(String)mySession.getAttribute("Enrollno");
        if(userName == null || enrollno==null || email==null){
            response.sendRedirect("LoginPage.jsp");
            return;
        }
        %>
        <div class="block">
            <p>NAME OF STUDENT*</p>
            <p><u><%= userName %></u></p>
        </div>
        <div class="block">
            <p>EMAIL*</p>
            <p><u><%= email %></u></p>
        </div>
        <div class="block">
            <p>ENROLLMENT NO*</p>
            <p><u><%= enrollno %></u></p>
        </div>
        <%
        final String url="jdbc:mysql://127.0.0.1:3306/quizz";
        final String dbusername="root";
        final String password="9689";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,dbusername,password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM questions";
            ResultSet resultSet=statement.executeQuery(query);
            %>
            <form action="Result.jsp" method="POST" >
                <%
                while(resultSet.next()){
                    int questions_id=resultSet.getInt("id");
                    String question=resultSet.getString("question");
                    String category=resultSet.getString("category");
                %>
                <div class="block">
                    <h2><%= questions_id %>    <%= question %></h2>
                    <p style="text-align: right;"><%= category %></p>
                    <%
                    String query1="SELECT id,option_text FROM options WHERE question_id=?";
                    PreparedStatement preparedStatement=connection.prepareStatement(query1);
                    preparedStatement.setInt(1,questions_id);
                    ResultSet rst=preparedStatement.executeQuery();
                    while(rst.next()){
                        int id=rst.getInt("id");
                        String option_text=rst.getString("option_text");
                        %>
                        <input type="radio" name="answer_<%= questions_id %>" value="<%= id %>" required/><%= option_text %>
                        <br>
                        <%
                    }
                    rst.close();
                    preparedStatement.close();
                    %>
                </div><%
            }
            %><br>
            <input type="submit" value="Submit" />
            <input type="reset" value="Clear form"/>
        </form>
        <%
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        %>
    </body>
</html>

