package JDBC_MySQL.BatchProcessing__DML_Commands;

import java.sql.*;

public class DeleteCommand {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //--------------------------USE of Batch-Processing---------------------------------------------------
        String query = "DELETE FROM emp WHERE employee_name = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            String[] name = {"Avis Bansal", "Avis Goyal"};
            for (String emp : name) {
                preparedStatement.setString(1, emp);
                preparedStatement.addBatch();
            }
            int[] rowsAffected = preparedStatement.executeBatch();
            if (rowsAffected.length > 0) {
                connection.commit();
                System.out.println("Successfully Delete Command Perform");
            } else {
                connection.rollback();
                System.out.println("Data Cannot exist in the table");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
