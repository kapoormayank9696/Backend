package JDBC_Project.Project_of_Student;

import java.sql.*;

public class AlterCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
//        try{
//            Connection connection = DriverManager.getConnection(url,username,password);
//            Statement statement = connection.createStatement();
//            String query = "ALTER TABLE students ADD CONSTRAINT PRIMARY KEY(roll_number)";
//            statement.executeUpdate(query);
//            System.out.println("ADD Constraint Are Successfully");
//            statement.close();
//            connection.close();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        try{
//            Connection connection = DriverManager.getConnection(url,username,password);
//            Statement statement = connection.createStatement();
//            String query = "ALTER TABLE students ADD COLUMN department VARCHAR(35)";
//            statement.executeUpdate(query);
//            System.out.println("Successfully Add Column in Table");
//            statement.close();
//            connection.close();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE students MODIFY COLUMN Age INTEGER NOT NULL";
            statement.executeUpdate(query);
            System.out.println("Successfully Modify the column");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
