package accesodatos;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Virginia, Erick y Jacqueline
 */
public class Connecion {
 private static Connection cnx = null;
 //static Connection cnn=null;
    static Statement sta=null;
    static ResultSet rst=null;
    
    static String user="local";
    static String pass="1234567890";
    static String url="jdbc:mysql://localhost:3306/fondo_cesantia";
    
    public static Connection enlace(Connection cnn){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             try {
              cnn=DriverManager.getConnection(url, user, pass);//el metodo getConnection siempre espera recibir un url,usuario y un password
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de url" +ex.getMessage());
            }
           
        } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"Error de Driver"+ex);    
        }
        return cnn;

}

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //cnx = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=bd_music","sa","admin001");
                cnx = DriverManager.getConnection(url, user, pass);
//                cnx = DriverManager.getConnection(url, user, pass);
                //jdbc:mysql://localhost:3306/bd_music?zeroDateTimeBehavior=convertToNull [root on Default schema]
            System.out.println("Conexion Exitosa"); 
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    public boolean crearConexion() throws ClassNotFoundException
    {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection(url, user, pass);
                //jdbc:mysql://localhost:3306/bd_music?zeroDateTimeBehavior=convertToNull [root on Default schema]
                System.out.println("Conexion Exitosa");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        
        return true; 
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
   
}
