package JDBC_MySQL.DDL_Commands;

import java.sql.*;

public class TruncateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/product";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //--------------------------TRUNCATE------------------------------------------------------------------
        //Truncate Command delete all inserted data but structure of data cannot delete(means table)
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "TRUNCATE TABLE transaction";
            statement.executeUpdate(query);
            System.out.println("Successfully Truncate Command Perform");
            connection.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
