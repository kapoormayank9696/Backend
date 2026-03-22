package JDBC_Project.Project_of_Student;

import java.sql.*;

public class SelectCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
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
            while(resultSet.next()){
                int id = resultSet.getInt("roll_number");
                String name = resultSet.getString("name");
                String mail = resultSet.getString("email");
                String pn = resultSet.getString("phone_number");
                String gen = resultSet.getString("gender");
                int a = resultSet.getInt("Age");
                String date = resultSet.getString("D_O_B");
                String depart = resultSet.getString("department");
                System.out.println("\t|"+id+"\t|"+name+"\t|"+mail+"\t|"+pn+"\t|"+gen+"\t|"+a+"\t|"+date+"\t|"+depart);
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
