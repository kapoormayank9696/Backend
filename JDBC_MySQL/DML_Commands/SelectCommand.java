//ALL Operations of the SELECT command

package JDBC_MySQL.DML_Commands;

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
        //--------------------------SELECT FOR ALL DATA PRINT-------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM emp");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print all Data of Mysql * : ");
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                System.out.print("\t| "+id);
                String name = resultSet.getString("employee_name");
                System.out.print("\t| "+name);
                String email= resultSet.getString("employee_email");
                System.out.print("\t| "+email);
                BigDecimal salary = resultSet.getBigDecimal("employee_salary");
                System.out.print("\t| "+salary);
                String joinDate = resultSet.getString("joining_Date");
                System.out.print("\t| "+joinDate);
                System.out.println();
            }
            System.out.println();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        //--------------------------WHERE (condition) RELATION OPERATOR---------------------------------------
        //print at specific position data
        //relation operator(>,<,=,>=,=<,<>) and logical operator((AND,&&) , (OR,||) , (NOT,!))
        //BETWEEN , ORDER BY keywords

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
//            String query = String.format("SELECT * FROM emp WHERE (employee_id >= 2 && employee_salary <= '99001.00')");
            String query = String.format("SELECT * FROM emp WHERE employee_salary BETWEEN '58564.00' AND '99001.00' ORDER BY employee_name");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print data from specific position by using WHERE(condition) RELATIONAL-LOGICAL operator and BETWEEN ,ORDER BY (keywords) : ");
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                System.out.print("\t| "+id);
                String name = resultSet.getString("employee_name");
                System.out.print("\t| "+name);
                String email = resultSet.getString("employee_email");
                System.out.print("\t| "+email);
                BigDecimal sal = resultSet.getBigDecimal("employee_salary");
                System.out.print("\t| "+sal);
                String join = resultSet.getString("joining_Date");
                System.out.print("\t| "+join);
                System.out.println();
            }
            System.out.println();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------PRINT NAMES OF EMPLOYEES--------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT employee_name,employee_salary FROM emp");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print Employee Names and Salary : ");
            while(resultSet.next()){
                String name = resultSet.getString("employee_name");
                System.out.print(name+"\t   ");
                BigDecimal sal = resultSet.getBigDecimal("employee_salary");
                System.out.println(sal);
            }
            System.out.println();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //--------------------------USE ALL keyword-----------------------------------------------------------
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT ALL employee_id FROM emp");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print Employee Id's by using ALL keyword : ");
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                System.out.print("\t| "+id);
                System.out.println();
            }
            System.out.println();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        //--------------------------USE ALIASES keyword-------------------------------------------------------
        // temporarily rename a column

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT employee_id ,employee_email AS 'Email' FROM emp");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print Data by using ALIASES keyword : ");
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                System.out.print(id + "  ");
                String email = resultSet.getString("Email");
                System.out.print(email + " ");
                System.out.println();
                connection.commit();
            }
            System.out.println();;
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        //--------------------------USE DISTINCT keyword------------------------------------------------------
        //Remove duplicate names or elements at print time

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT DISTINCT(employee_name) FROM emp");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Print Names by using DISTINCT keywords : ");
            while(resultSet.next()){
                String name = resultSet.getString("employee_name");
                System.out.println(name);
            }
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        //--------------------------In , NOT IN keywords------------------------------------------------------
        //--------------------------LIKE ,NOT LIKE(% are not use but %% works in it)--------------------------

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement =  connection.createStatement();
//            String query = String.format("SELECT * FROM emp WHERE employee_id NOT IN('2')");
            String query = String.format("SELECT * FROM emp WHERE employee_name NOT LIKE 'B%%'");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("In, Not In, Like, Not Like, Is keyword : ");
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                System.out.print("\t|"+id);
                String name = resultSet.getString("employee_name");
                System.out.print("\t| "+name);
                String email = resultSet.getString("employee_email");
                System.out.print("\t| "+email);
                int sal = resultSet.getInt("employee_salary");
                System.out.print("\t| "+sal);
                String date = resultSet.getString("joining_Date");
                System.out.print("\t| "+date);
                System.out.println();
            }
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
