package JDBC_MySQL.DDL_Commands;

import java.sql.*;

public class CreateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //--------------------------CREATE DATABASE-----------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "CREATE DATABASE employee";
            statement.execute(query);
            System.out.println("successfully Create DataBase");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------CREATE TABLE--------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE emp1(employee_id INTEGER,employee_name VARCHAR(21),employee_email VARCHAR(30),employee_salary INTEGER)";
            statement.execute(query);
            System.out.println("Successfully Create Table");
            statement.close();
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
