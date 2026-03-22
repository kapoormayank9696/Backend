package JDBC_Project.Project_of_store;

import java.sql.*;

public class ResultSetMetaData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------Result Set Meta Data------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM items";
            ResultSet resultSet = statement.executeQuery(query);

            java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            System.out.println("Types of column in the Table :");
            for(int i=1;i<=count;i++){
                System.out.println("Column"+i+" "+resultSetMetaData.getColumnTypeName(i));
            }
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
