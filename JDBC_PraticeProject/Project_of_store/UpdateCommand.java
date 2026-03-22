package JDBC_Project.Project_of_store;

import java.sql.*;

public class UpdateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------Update Command------------------------------------------------------------
        String query = "UPDATE items SET price = price + (price / ?) WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setInt(1,(Integer) 10);
            preparedStatement.setInt(2,(Integer) 3);
            preparedStatement.addBatch();

            int[] rowsAffected = preparedStatement.executeBatch();
            if(rowsAffected.length> 0){
                connection.commit();
                System.out.println("Update The Table Data");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
