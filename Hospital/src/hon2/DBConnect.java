package hon2;

import javax.swing.*;
import java.sql.*;

public class DBConnect 
{
    Connection conn = null;
    public static Connection ConnectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "itp", "itp");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
