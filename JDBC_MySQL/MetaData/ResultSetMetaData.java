package JDBC_MySQL.MetaData;

import java.sql.*;

import java.sql.DriverManager;

public class ResultSetMetaData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM emp";
            ResultSet resultSet = statement.executeQuery(query);

            java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int column_count = resultSetMetaData.getColumnCount();
            System.out.println("Total Column : "+column_count);
            for(int i=1;i<=column_count;i++){
                System.out.println("Column "+i+" : "+resultSetMetaData.getColumnName(i)+" ( "+resultSetMetaData.getColumnTypeName(i)+")");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
