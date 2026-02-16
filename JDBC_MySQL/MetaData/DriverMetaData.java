package JDBC_MySQL.MetaData;

import java.sql.*;

public class DriverMetaData {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.01:3306/employee","root","9689");
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println("Database Product Name : "+databaseMetaData.getDatabaseProductName());
        System.out.println("Database version : "+databaseMetaData.getDatabaseProductVersion());
        System.out.println("Driver Name : "+databaseMetaData.getDriverName());
        System.out.println("Driver version : "+databaseMetaData.getDriverVersion());
        System.out.println("User name : "+databaseMetaData.getUserName());

        ResultSet resultSet = databaseMetaData.getTables(null , null, "%", new String[]{"TABLE"});
        System.out.println("List of Tables : ");
        while(resultSet.next()){
            System.out.print(resultSet.getString("TABLE_NAME")+"\t");
        }
        connection.close();
    }
}
