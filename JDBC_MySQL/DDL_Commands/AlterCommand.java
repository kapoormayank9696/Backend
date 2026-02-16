package JDBC_MySQL.DDL_Commands;

import java.sql.*;

public class AlterCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password =  "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //--------------------------ADD COLUMN----------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp ADD COLUMN joining_Date DATETIME DEFAULT NOW()";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            connection.close();
            statement.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------MODIFY--------------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp MODIFY employee_email VARCHAR(50) NOT NULL";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------MODIFY COLUMN-------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp MODIFY COLUMN employee_email VARCHAR(50)";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------DROP COLUMN---------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp DROP joining_Date";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Performed");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------RENAME TABLE--------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp RENAME emp1";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------RESET AUTO INCREMENT------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);;
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp1 AUTO_INCREMENT = 1";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------ADD CONSTRAINT------------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "ALTER TABLE emp1 ADD CONSTRAINT PRIMARY KEY(employee_id)";
            statement.executeUpdate(query);
            System.out.println("Successfully Alter Command Perform");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------ALTER_READ ONLY = 0-------------------------------------------------------
        //Only Select Command use in it  no use other command in it
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "ALTER emp1 READ ONLY = 1";
            statement.executeUpdate(query);
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
