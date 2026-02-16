package JDBC_MySQL.MetaData;

import java.sql.*;

public class ParameterMetaData {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO emp VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            java.sql.ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();
            System.out.println("Total parameters : "+count);
            for(int i = 1;i <= count;i++){
                System.out.println("Parameter "+i+" : "+parameterMetaData.getParameterTypeName(i));
            }
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
