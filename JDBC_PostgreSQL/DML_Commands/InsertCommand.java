package JDBC_PostgreSQL.DML_Commands;

import java.sql.*;
public class InsertCommand {

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

        //--------------------------INSERT MULTIPLE DATA OR SINGLE LINE DATA-From Postgresql-----------------------
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            Statement statement=connection.createStatement();
            String query="INSERT INTO s VALUES(1,'Maya','mayankkapoor379@gmail.com'),"+
                    "(2,'Dev','devKapoor67@gmail.com'),"+
                    "(3,'Sophia Leone','sophialeone145@gmail.com'),"+
                    "(4,'Baki Hanma','bakihanma564@gmail.com')";
            int rowsAffected=statement.executeUpdate(query);
            if(rowsAffected > 0){
                connection.commit();
                System.out.println("Successfully Data Inserted Into Table");
            }else{
                connection.rollback();
                throw new SQLException("......!Duplicate Data!.......");
            }
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
