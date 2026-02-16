package JDBC_MySQL.DML_Commands;

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
        //--------------------------DELETE COMMAND------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM emp WHERE employee_id = 1");
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected > 0){
                System.out.println("Successfully Delete Command Perform");
            }
            else{
                connection.rollback();
                System.out.print("Data cannot exist in the table");
            }
            connection.commit();
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
