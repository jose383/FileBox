package model;

import java.sql.*;

public class ValidateSWE
 {
     public static boolean checkUser(String email,String password)
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con = DriverManager.getConnection
                        ("jdbc:mysql:/ /localhost:8080/cs3220stu115","id","studytonight");
         PreparedStatement ps =con.prepareStatement
                             ("select * from users where email=? and password=?");
         ps.setString(1, email);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}