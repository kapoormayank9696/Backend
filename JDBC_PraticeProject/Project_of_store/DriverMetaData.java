package JDBC_Project.Project_of_store;

import java.sql.*;

public class DriverMetaData {
    public static void main(String[] args) throws Exception {
       Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store","root","9689");
       DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("Database Product Name :  "+databaseMetaData.getDatabaseProductName());
        System.out.println("Database Product Version :  "+databaseMetaData.getDatabaseProductVersion());
        System.out.println("Driver Product Name : "+databaseMetaData.getDriverName());
        System.out.println("Driver Product Version : "+databaseMetaData.getDriverVersion());
        System.out.println("User Name : "+databaseMetaData.getUserName());

        //--------------------------Print Table Names---------------------------------------------------------
        ResultSet resultSet = databaseMetaData.getTables(null,null,"%",new String[]{"TABLE"});
        while(resultSet.next()){
            System.out.print(resultSet.getString("TABLE_NAME")+"\t");
        }
    }
}
