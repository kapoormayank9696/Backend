package JDBC_MySQL.DML_Commands;

import java.sql.*;

public class UpdationCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = "UPDATE emp SET employee_salary = employee_salary + (employee_salary /10) WHERE employee_salary < 55000.00";
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected > 0){
                connection.commit();
                System.out.println("Successfully Update Command Perform");
            }else{
                connection.rollback();
                System.out.println("No employees have employee_salary below 55000.00");
            }
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
