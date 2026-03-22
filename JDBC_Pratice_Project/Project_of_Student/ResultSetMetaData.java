package JDBC_Project.Project_of_Student;

import java.sql.*;

public class ResultSetMetaData {
    private static final String url = "jdbc:mysql://127.0.01:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "SELECT * FROM students";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            System.out.println("Table Have "+count+" Columns..");
            for(int i=1;i<=count;i++){
                System.out.println(resultSetMetaData.getColumnName(i)+":"+i+" ("+resultSetMetaData.getColumnTypeName(i)+")");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
