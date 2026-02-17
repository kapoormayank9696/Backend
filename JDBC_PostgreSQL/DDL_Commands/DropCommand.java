package JDBC_PostgreSQL.DDL_Commands;

import java.sql.*;
public class DropCommand {

    // Main function
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://127.0.0.1:5432/students";
        String username="postgres";
        String password="9689";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            throw new Exception("Cannot connect with Postgresql");
        }
        //--------------------------Drop Table From Postgresql-----------------------------------------------------
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="DROP TABLE s";
            //  String query1="DROP TABLE  IF EXISTS s";
            int rowsAffected =statement.executeUpdate(query);
            if(rowsAffected == 0){
                System.out.println("Successfully Drop Table");
            }else{
                System.out.println("error");
            }
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
