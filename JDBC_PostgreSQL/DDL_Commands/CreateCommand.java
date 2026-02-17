package JDBC_PostgreSQL.DDL_Commands;

import java.sql.*;
public class CreateCommand {

    // Main function
    public static void main(String[] args) {
        String url="jdbc:postgresql://127.0.0.1:5432/students";
        String username="postgres";
        String password="9689";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------Create Table From Postgresql---------------------------------------------------
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="CREATE TABLE s(s_Id SERIAL PRIMARY KEY, s_Name VARCHAR(10) NOT NULL, s_Email VARCHAR(20) UNIQUE NOT NULL)";
            statement.execute(query);
            System.out.println("Successfully Table Create..");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
