package JDBC_Project.Project_of_Student;

import java.sql.*;

public class DeleteCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "DELETE FROM students WHERE roll_number = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            int[] data = {110,107};
            for(int emp : data){
                preparedStatement.setInt(1,(Integer) emp);
                preparedStatement.addBatch();
            }
            int[] rowsAffected = preparedStatement.executeBatch();
            if(rowsAffected.length > 0){
                System.out.println("Successfully Delete Data From Table");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
