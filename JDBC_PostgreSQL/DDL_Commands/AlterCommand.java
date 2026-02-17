package JDBC_PostgreSQL.DDL_Commands;

import java.sql.*;
public class AlterCommand {

    // Main function
    public static void main(String[] args) {
        String url="jdbc:postgresql://127.0.0.1:5432/students";
        String username="postgres";
        String password="9689";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            e.getMessage();
        }

        //------------------------
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="ALTER TABLE s "+
                    "ALTER COLUMN s_Email TYPE VARCHAR(100),"+
                    "ALTER COLUMN s_Email SET DEFAULT 'Unknown',"+
                    "ADD CONSTRAINT s_Email UNIQUE(s_Email)";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
