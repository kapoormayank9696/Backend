package JDBC_PostgreSQL.DML_Commands;

import java.sql.*;
public class UpdateCommand {

    // Main function
    public static void main(String[] args) {
        String url="jdbc:postgresql://127.0.0.1:5432/students";
        String username="postgres";
        String password="9689";
        try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception e){
            e.getMessage();
        }

        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement=connection.createStatement();
            String query="UPDATE s SET ";
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected > 0){
                connection.commit();
                System.out.println("Successfully Update Command");
            }
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
