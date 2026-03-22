package JDBC_Project.Project_of_store;

import java.sql.*;

public class CreateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
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
            String query = "CREATE DATABASE store";
            statement.execute(query);
            System.out.println("Successfully Database Create");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        //--------------------------CREATE TABLE--------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE items(id INTEGER, name VARCHAR(50),price DECIMAL(5,2),stock INTEGER,manufacture_date VARCHAR(10), expiry_date VARCHAR(10),company_name VARCHAR(50))";
            statement.execute(query);
            System.out.println("Successfully Table Create");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
