package airline.management.system;

import java.sql.*;  

public class conn{
   static Connection con = null; 
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_ms","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}  