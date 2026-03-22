package JDBC_Project.Project_of_Student;

import java.sql.*;

public class ParameterMetaData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "INSERT INTO students VALUES(?,?,?,?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            java.sql.ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();
            System.out.println("Number of Parameter in the Table : "+count);
            for(int i=1;i<=count;i++){
                System.out.println(parameterMetaData.getParameterTypeName(i)+"");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
