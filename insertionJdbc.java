import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertionJdbc {
    public static void main(String[] args) throws ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:3306/jdbc";
        String USER = "root";
        String PASS = "Sanket@3006";

        String query = "INSERT INTO employees (id, name, jobTital, salary) VALUES (6, 'Nitin Jadhav', 'Developer', 65000);";
        String query1 = "Delete from employees where id = 6;";
        String query2 = "Update employees set name = 'Mahesh Patil' where id = 2;";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connection successfully established!!!");

            Statement stm = con.createStatement();
            int rowsAffected = stm.executeUpdate(query2);

            if(rowsAffected>0){
                System.out.println("Insert Data successfully: " + rowsAffected + "Rows Affected");
            }else {
                System.out.println("Not Inserted!!!!!!!!!!!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
