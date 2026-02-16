package JDBC_MySQL.PreparedStatement_DML_Command;

import java.sql.*;

public class UpdateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "UPDATE emp SET employee_salary = employee_salary+ (employee_salary /?) WHERE employee_salary < ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setInt(1,10);
            preparedStatement.setDouble(2,75000.78);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                connection.commit();
                System.out.println("Successfully Update Command Perform");
            }
            preparedStatement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
