package sgme.carder;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Senghor AKOMINON
 */
public class JDBConnection 
{
    private final  String url = "jdbc:mysql://localHost/dbCarder";
    private final  String user = "root";
    private final  String password = "";
    public JDBConnection(){}
    public Connection getJDBConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Chargement de pilote échoué ! ");
        }
        return connection;
    }
    public Connection getJDBConnection(String Host, String User, String Password)
    {
        String Url = "jdbc:mysql://"+Host+"/dbCarder";
        Connection connection = null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection(Url, User, Password);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return connection;
    }
}
