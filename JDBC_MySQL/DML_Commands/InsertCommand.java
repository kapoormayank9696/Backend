package JDBC_MySQL.DML_Commands;

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
        //--------------------------INSERT MULTIPLE DATA OR SINGLE LINE DATA----------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO emp VALUES(1,'John Mendez','john789@gmail.com',25000.80,'2020-11-12'),"+
                    "(2,'Natal Michael','natalmicahel34@gmail.com',40000.20,'2018-6-1')," +
                    "(3,'Sophia Leone','sophialeone145@gmail.com',55000.00,'2019-2-1')," +
                    "(4,'Baki Hanma','bakihanma564@gmail.com',99000.54,'2021-1-1')");
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected > 0){
                connection.commit();
                System.out.println("Successfully Data Inserted Into Table");
            }
            else{
                connection.rollback();
                throw new SQLException("......!Duplicate Data!.......");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
