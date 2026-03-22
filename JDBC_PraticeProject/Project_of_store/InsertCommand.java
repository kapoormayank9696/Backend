package JDBC_Project.Project_of_store;

import java.sql.*;

public class InsertCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //--------------------------INSERT DATA---------------------------------------------------------------
        String query = "INSERT INTO items VALUES(?,?,?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            Object[][] num = {{1,"Milk",1.50,100,"2025-11-15","2025-10-01","DairyLand"},
                    {2,"Bread",2.00,200,"2025-10-30","2025-10-15","BakeHouse"},
                    {3,"Eggs",3.00,150,"2025-11-10","2025-10-05","FarmFresh"},
                    {4,"Butter",4.50,80,"2026-01-01","2025-09-20","CreamyGoodness"},
                    {5,"Cheese",5.00,120,"2026-02-15","2025-10-10","DairyLand"},
                    {6,"Yogurt",1.80,90,"2025-11-20","2025-10-10","FarmFresh"},
                    {7,"Chicken Breast",6.50,50,"2025-11-05","2025-10-20","ProteinPlus"},
                    {8,"Beef Steak",8.00,40,"2025-12-01","2025-10-25","MeatMasters"},
                    {9,"Apple",0.80,300,"2025-11-30","2025-10-18","FreshFruits"},
                    {10,"Orange",0.90,250,"2025-12-05","2025-10-20","FreshFruits"},
                    {11,"Rice",1.20,500,"2027-10-28","2025-01-01","GrainCorp"},
                    {12,"Pasta",1.50,400,"2026-05-01","2025-09-01","PastaWorld"},
                    {13,"Tomato Sauce",2.20,150,"2026-03-01","2025-10-01","SaucyDelight"},
                    {14,"Olive Oil",7.00,60,"2027-01-01","2025-07-01","OilMasters"},
                    {15,"Salt",0.50,800,"2028-12-31","2025-01-01","SpiceWorld"},
                    {16,"Sugar",1.00,600,"2027-12-31","2025-01-01","SweetFactory"},
                    {17,"Tea",3.50,200,"2026-08-01","2025-09-01","TeaTime"},
                    {18,"Coffee",4.50,180,"2026-09-01","2025-09-01","BeanBrew"},
                    {19,"Cereal",3.00,220,"2026-04-15","2025-10-01","MorningMunch"},
                    {20,"Chocolate",2.50,300,"2026-02-10","2025-10-15","SweetFactory"}
            };
            for(Object[] nums : num){
                preparedStatement.setInt(1,(Integer) nums[0]);
                preparedStatement.setString(2,(String) nums[1]);
                preparedStatement.setDouble(3,(Double) nums[2]);
                preparedStatement.setInt(4,(Integer) nums[3]);
                preparedStatement.setString(5,(String) nums[4]);
                preparedStatement.setString(6,(String) nums[5]);
                preparedStatement.setString(7,(String) nums[6]);
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
