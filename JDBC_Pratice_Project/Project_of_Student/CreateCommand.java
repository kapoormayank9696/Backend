package JDBC_Project.Project_of_Student;

import java.sql.*;

public class CreateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "CREATE DATABASE student";
            statement.execute(query);
            System.out.println("Successfully Create Database");
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE students(roll_number INTEGER, name VARCHAR(30),email VARCHAR(40),phone_number INTEGER,gender VARCHAR(5),Age DECIMAL(5,2),D_O_B VARCHAR(20))";
            statement.execute(query);
            System.out.println("Successfully Create Table");
            connection.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
