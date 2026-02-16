package JDBC_MySQL.CollableStatment;

import java.sql.*;

public class SelectCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection connection = DriverManager.getConnection(url,username,password);
         java.sql.CallableStatement callableStatement = connection.prepareCall("{call getemployee_name(?)}")){
            callableStatement.setInt(1,5);
//            callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("employee_name");
                System.out.println("Name of person : "+name);
            };
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
