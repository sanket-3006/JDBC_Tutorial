import java.sql.*;

public class firstJdbcProgram {
    public static void main(String[] args) throws ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:3306/jdbc";
        String USER = "root";
        String PASS = "Sanket@3006";

        String query = "Select * from employees;";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connection establish successfully!!!");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String jobTital = rs.getString("jobTital");
                Double salary = rs.getDouble("salary");

                System.out.println();
                System.out.println("==============================");
                System.out.println("Id: " +id);
                System.out.println("Name: "+name);
                System.out.println("job Tital: "+ jobTital);
                System.out.println("Salary: "+ salary);
            }

            rs.close();
            stm.close();
            con.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }




    }
}
