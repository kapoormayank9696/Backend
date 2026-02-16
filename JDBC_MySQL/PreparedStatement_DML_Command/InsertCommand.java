package JDBC_MySQL.PreparedStatement_DML_Command;

import java.sql.*;

public class InsertCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "INSERT INTO emp VALUES(?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            Object[][] employee = {
                    {15,"Avis Goyal","avis345@gmail.com",89000.89,},
                    {19,"Pushpa","pushpalbapodora24@gmail.com",300000.89}
            };
            for(Object[] emp : employee){
                preparedStatement.setInt(1,(Integer) emp[0]);
                preparedStatement.setString(2,(String) emp[1]);
                preparedStatement.setString(3,(String) emp[2]);
                preparedStatement.setDouble(4,(Double) emp[3]);
                 preparedStatement.addBatch();
            }
            int[] rowsAffected = preparedStatement.executeBatch();
            if(rowsAffected.length > 0){
                connection.commit();
                System.out.println("Successfully Insert Command Perform");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
