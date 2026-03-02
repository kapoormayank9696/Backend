package JDBC_PostgreSQL.DDL_Commands;

import java.sql.*;
public class TruncateCommand {
    // Define url,username,password of postgresql
    final static String url="jdbc:postgresql://127.0.0.1:5432/students";
    final static String username="postgres";
    final static String password="9689";

    // Main function
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            e.getMessage();
        }

        //--------------------------Truncate Table From Postgresql-------------------------------------------------
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="TRUNCATE TABLE s";
            statement.executeUpdate(query);
            System.out.println("Successfully Truncate Table");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
