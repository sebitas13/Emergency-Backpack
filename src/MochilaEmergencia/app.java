/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MochilaEmergencia;


import Modelo.Usuario;
import sistema.Configuracion;
import Vista.FrameLogin;
import Vista.FramePrincipal;
import java.sql.Connection;





/**
 *
 * @author USUARIO
 */
public class app {

   
    
    
    
    public static void main(String[] args) {
        
        
         Connection con = Conexion.getConnection();
        diseño();
      
        
        //Se agrega al admin
        Configuracion.usuarios.add(new Usuario("admin", "123", "sebas"));
         
        FrameLogin frmL = new FrameLogin("admin","123");
        frmL.setVisible(true);
        frmL.setLocationRelativeTo(null);
   
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
          Conexion.desconexion();
        }));
        
    }
    
    
     
     public static void diseño(){
         
           try {
             
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
         
     }
     
    
     
     
}
