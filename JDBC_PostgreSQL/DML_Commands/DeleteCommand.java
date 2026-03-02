package JDBC_PostgreSQL.DML_Commands;

import java.sql.*;
public class DeleteCommand {
    // Define url,username,password of postgresql
    final static String url="jdbc:postgresql://127.0.0.1:5432/students";
    final static String username="postgres";
    final static String password="9689";

    // Main function
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e) {
            e.getMessage();
        }
        //--------------------------DELETE COMMAND------------------------------------------------------------
        try {
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="DELETE FROM s";
            int rowsAffected=statement.executeUpdate(query);
            if(rowsAffected > 0) {
                System.out.println("Successfully Delete Perform....");
            }else {
                System.out.println("error!!!");
            }
            statement.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
