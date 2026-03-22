package JDBC_Project.Project_of_Student;

import java.sql.*;

public class InsertCommand {
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
            connection.setAutoCommit(false);
            Object[][] data = {
                    {101,"Aarav Sharma","aarav.sharma@univ.edu","9876543210","Male",19,"12-03-2006","Computer Science"},
                    {102,"Priya Mehta","priya.mehta@univ.edu","9876543211","Female",18,"25-07-2007","Information Tech"},
                    {103,"Rohan Patel","rohan.patel@univ.edu","9876543212","Male",20,"10-11-2005","Mechanical Engg"},
                    {104,"Sneha Verma","sneha.verma@univ.edu","9876543213","Female",19,"02-05-2006","Electronics Engg"},
                    {105,"Karan Singh","karan.singh@univ.edu","9876543214","Male",21,"18-01-2004","Civil Engg"},
                    {106,"Ananya Gupta","ananya.gupta@univ.edu","9876543215","Female",18,"29-09-2007","Computer Science"},
                    {107,"Arjun Nair","arjun.nair@univ.edu","9876543216","Male",20,"06-12-2005","Electrical Engg"},
                    {108,"Meera Iyer","meera.iyer@univ.edu","9876543217","Female",19,"14-08-2006","Computer Science"},
                    {109,"Rahul Das","rahul.das@univ.edu","876543218","Male",21,"23-02-2004","Mechanical Engg"},
                    {110,"Neha Reddy","neha.reddy@univ.edu","9876543219","Female",18,"05-06-2007","Information Tech"}
            };
            for(Object[] emp : data){
                preparedStatement.setInt(1,(Integer) emp[0]);
                preparedStatement.setString(2,(String) emp[1]);
                preparedStatement.setString(3,(String) emp[2]);
                preparedStatement.setString(4,(String) emp[3]);
                preparedStatement.setString(5,(String) emp[4]);
                preparedStatement.setInt(6,(Integer) emp[5]);
                preparedStatement.setString(7,(String) emp[6]);
                preparedStatement.setString(8,(String) emp[7]);
                preparedStatement.addBatch();
            }
            int[] rowsAffected = preparedStatement.executeBatch();
            if(rowsAffected.length > 0){
                connection.commit();
                System.out.println("Successfully Data Insert Into Table");
            }
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
