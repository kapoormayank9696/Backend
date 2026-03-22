package JDBC_Project.Project_of_store;

import java.sql.*;

public class SelectCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------SELECT COMMAND------------------------------------------------------------
        String query = "SELECT * FROM items";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double stock = resultSet.getDouble("stock");
                String man_date = resultSet.getString("manufacture_date");
                String exp_date = resultSet.getString("expiry_date");
                String comname = resultSet.getString("company_name");
                System.out.println("\t|"+id+"\t|"+name+"\t|"+price+"\t|"+stock+"\t|"+man_date+"/t|"+exp_date+"\t|"+comname);
            }
            connection.close();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
