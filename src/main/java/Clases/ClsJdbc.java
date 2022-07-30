
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author davidperezarias
 */
public class ClsJdbc {
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String usuario = "root";
    String contrasenia = "";
    String bd = "bd_elecciones_g9";
    String puerto = "3306";
    String url = "jdbc:mysql://localhost:" + puerto + "/" + bd;
    public Connection conexion;
    
    public void CrearConexion(){
        
        try {
            
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url, usuario, contrasenia);
            
            if(conexion != null){
                System.out.println("conexión exitosa");
            } 
          
        } catch (Exception e) {
             System.out.println("Ups ocurrió un error en la conexión" + e.getMessage());
        }
        
    }
    
 
    
}
