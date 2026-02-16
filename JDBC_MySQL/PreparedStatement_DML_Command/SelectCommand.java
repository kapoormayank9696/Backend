package JDBC_MySQL.PreparedStatement_DML_Command;

import java.math.BigDecimal;
import java.sql.*;

public class SelectCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/employee";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query = "SELECT * FROM emp WHERE employee_id >= ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,(Integer) 4);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String mail = resultSet.getString("employee_email");
                BigDecimal sal = resultSet.getBigDecimal("employee_salary");
                System.out.println("\t|"+id+"\t| "+name+"\t| "+mail+"\t| "+sal+"|");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
