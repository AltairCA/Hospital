package patient_records_mng_sys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
;

/**
 *
 * @author S.Jayasinghe
 */
public class dbconnect {
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
            JOptionPane.showMessageDialog(null, "Database Not Connected");
            return null;
        }
    }
    
}
