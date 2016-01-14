/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnect;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Janith Kularathne
 */
public class DBconnect {
    
    public static Connection connect()
    {
        Connection conn;
        conn = null;
        
        try
        {    
            Class.forName("com.mysql.jdbc.Driver");
        
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
        
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Database not found");
        
        
        }
        
        return conn;
    
    }
    
}
