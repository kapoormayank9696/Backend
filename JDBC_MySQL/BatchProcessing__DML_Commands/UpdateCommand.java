package JDBC_MySQL.BatchProcessing__DML_Commands;

import java.sql.*;

public class UpdateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "Update emp SET employee_salary = ? WHERE employee_id = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setDouble(1,95000);
            preparedStatement.setInt(2,3);
            preparedStatement.addBatch();

            preparedStatement.setDouble(1,75000);
            preparedStatement.setInt(2,5);
            preparedStatement.addBatch();

            preparedStatement.setDouble(1,115000);
            preparedStatement.setInt(2,19);
            preparedStatement.addBatch();

            int[] rowsAffected = preparedStatement.executeBatch();
            if(rowsAffected.length > 0){
                connection.commit();
                System.out.println("Successfully Update Command Perform");
            }else{
                System.out.println("Data cannot exist in the table");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
