package JDBC_MySQL.DDL_Commands;

import java.sql.*;

public class DropCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //--------------------------Drop Table From Mysql-----------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("DROP TABLE emp1");
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected == 0){
                System.out.println("successfully Drop Table");
            }else{
                System.out.println("error");
            }
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------Drop DataBase From Mysql--------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "DROP DATABASE employee";
            statement.executeUpdate(query);
            System.out.println("Successfully DataBase Deleted");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
