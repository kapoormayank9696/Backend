package JDBC_Project.Project_of_store;

import java.sql.*;

public class DeleteCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------DELETE COMMAND------------------------------------------------------------
        String query = "DELETE FROM items WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            int[] num = {3,9,20};
            for(int nums:num){
                preparedStatement.setInt(1,(Integer) nums);
                preparedStatement.addBatch();
            }
          int[] rowsAffected = preparedStatement.executeBatch();
          if(rowsAffected.length  > 0){
              System.out.println("Successfully Delete Data From Table");
          }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
