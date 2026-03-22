package JDBC_Project.Project_of_Student;

import java.sql.*;

public class DriverMetaData {
    public static void main(String[] args) throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?username=root","root","9689");
        java.sql.DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("Database Product Name : "+databaseMetaData.getDatabaseProductName());
        System.out.println("DataBase Product Version : "+databaseMetaData.getDatabaseProductVersion());
        System.out.println("Driver Product Name : "+databaseMetaData.getDriverName());
        System.out.println("Driver Product Version : "+databaseMetaData.getDriverVersion());
        System.out.println("User Name : "+databaseMetaData.getUserName());
        ResultSet resultSet = databaseMetaData.getTables(null,null,"%",new String[]{});
        System.out.println();
        System.out.print("Tables Name Which are present in the Mysql : ");
        while(resultSet.next()){
            System.out.print(resultSet.getString("TABLES_NAME")+" ");
        }
        connection.close();
    }
}
