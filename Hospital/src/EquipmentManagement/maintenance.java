/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipmentManagement;

import java.awt.Color;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Prabhath
 */
public class maintenance {
    main m45 = new main();
    
    public void insertdata(String mt, String daterr)
    {
        
        
        //java.util.Date utilDate = new java.util.Date();
    //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    String mt1 = mt;
        String dat1 = daterr;
        
        try
    {
      // create a mysql database connection
       String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/itp";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "itp", "itp");
     
      // create a sql date object so we can use it in our INSERT statement
     Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                String dater = startDate.toString();
 
      
      
    
      
      
      
      // the mysql insert statement
      String query = " insert into maintenance (Machine_Type, Date, Added_Date )"
        + " values (?, ?, ?)";
 
      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, mt1);
      preparedStmt.setString (2,daterr);
      preparedStmt.setString (3, dater);
      
      
 
      // execute the preparedstatement
      preparedStmt.execute();
       
      conn.close();
      
      
     
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  

        
        
    }
    

    
}
