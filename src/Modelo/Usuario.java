
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    
    private String nombre;
    private String usuario;
    private String contraseña;
    private boolean loguin;
    private boolean remember;
    private Usuario izq;
    private Usuario der;

    public Usuario(String usuario, String contraseña,String nombre) {
       
       // this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre=nombre;
        this.loguin = false;
    }
    
    
    public boolean validar(String user , String pass){
        boolean result=false;
        
        if(usuario.equalsIgnoreCase(user) 
                &&contraseña.equalsIgnoreCase(pass) && !this.loguin ){
            this.setLoguin(true);
            result = true;
            
        }
     return result;   
    }
    
    
     public boolean cerrarSesion(){
        boolean result = false;
        
        if(this.isLoguin()){
            this.setLoguin(false);
            result=true;
        }
        
        return result;
    }
    
     //Get and Set
    
    public boolean isLoguin() {    
        return loguin;
    }

   
    public void setLoguin(boolean loguin) {
        this.loguin = loguin;
    }


    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario getIzq() {
        return izq;
    }

    public Usuario getDer() {
        return der;
    }

    public void setIzq(Usuario izq) {
        this.izq = izq;
    }

    public void setDer(Usuario der) {
        this.der = der;
    }

    public String getNombre() {
        return nombre;
    }

    
    
}
