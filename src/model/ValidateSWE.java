package model;

import java.sql.*;

public class ValidateSWE
 {
     public static boolean checkUser(String email,String password)
     {
         boolean st =false;
         try
         {
             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu115";
             String dbUsername = "cs3220stu115";
             String dbPassword = "G!jxS5!m";

             // Loading Driver for MySQL
             //Class.forName("com.mysql.jdbc.Driver"); // Not Necessary

             // Creating connection with the database
             Connection c = DriverManager.getConnection(url, dbUsername, dbPassword);

             // Check info
             PreparedStatement ps;
             ps = c.prepareStatement("select email, password from users where email=? and password=?");
             ps.setString(1, email);
             ps.setString(2, password);
             ResultSet rs = ps.executeQuery();
             st = rs.next();
         }
         catch(Exception e)
         {
          e.printStackTrace();
         }

         return st;
  }   
}