package JDBC_Project.Project_of_store;

import java.sql.*;

public class DropCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------DROP TABLE----------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "DROP TABLE items";
            statement.executeUpdate(query);
            System.out.println("successfully Drop Table");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        //--------------------------DROP DATABASE-------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "DROP DATABASE store";
            statement.executeUpdate(query);
            System.out.println("Successfully Drop DataBase");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
