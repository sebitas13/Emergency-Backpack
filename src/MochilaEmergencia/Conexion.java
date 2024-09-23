
package MochilaEmergencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static Connection con = null;
        private Conexion(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:oracle:thin:@localhost:1521:XE";
            String usuario= "mochila";
            String password = "123";
            
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registro","root","12345678");
            
            
            con=DriverManager.getConnection(myDB,usuario,password);
            if(con!=null){
                System.out.println("Conexion exitosa: "+con);
            }else{
                System.out.println("No hubo conexion");
            }
            
        } catch (SQLException e) {
            System.err.println("Error:"+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    public static Connection getConnection(){
        if(con == null){
            new Conexion();
        }
        return con;
    }
    
    public static void desconexion(){
        try {
            
            if(con!=null && !con.isClosed()){
               con.close(); 
               con = null;
               System.out.println("Conexion cerrada");
            }
            
        } catch (Exception e) {
            System.out.println("Error al desconectar"+e.getMessage());
        }
    }
    
  }
