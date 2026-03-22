package JDBC_Project.Project_of_Student;

import java.sql.*;

public class UpdateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "UPDATE students SET age = age +(age / ?) WHERE age <= ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setInt(1,10);
            preparedStatement.setInt(2,18);
            preparedStatement.addBatch();

            int[] rowAffected = preparedStatement.executeBatch();
            if(rowAffected.length > 0){
                connection.commit();
                System.out.println("Successfully Update The Table");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
