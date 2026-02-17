package JDBC_PostgreSQL.DML_Commands;

import java.sql.*;
public class SelectCommand {

    // Main function
    public static void main(String[] args) {
        String url="jdbc:postgresql://127.0.0.1:5432/students";
        String username="postgres";
        String password="9689";
        try{
            Class.forName("org.postgresql.Driver");
        }catch (Exception e){
            e.getMessage();
        }

        //--------------------------SELECT COMMAND From Postgresql-----------------------
        try {
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM s";
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()) {
                int id=resultSet.getInt("s_Id");
                String name=resultSet.getString("s_Name");
                String email=resultSet.getString("s_Email");
                System.out.println("\t| "+id+"\t| "+name+"\t| "+email);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
