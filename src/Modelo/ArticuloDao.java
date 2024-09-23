/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import MochilaEmergencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author USUARIO
 */
public class ArticuloDao {
    
     private String mensaje="";
     
    // Conexion conexion;
     
     public ArticuloDao(){
    
         //conexion = new Conexion();
    }

    
    
    public String agregarArticulo(Articulo art){
        Connection con = Conexion.getConnection();
        
        PreparedStatement pst =null;
        String sql = "INSERT INTO articulo (ID,NOMBRE,PESO,VALOR,ID_CATEGORIA,ID_TIPO) "
                +" VALUES(MOCHILA_SEQ.nextval,?,?,?,?,?)"; 
       
        
        try{
            pst = con.prepareStatement(sql);
            
           // pst.setString(1, art.getID());
            pst.setString(1, art.getNombre());
            pst.setFloat(2, art.getPeso());
            pst.setInt(3, art.getValor());
            pst.setString(4, art.getCodCat());
            pst.setString(5, art.getCodTipo());
            mensaje= "GUARDADO CORRECTAMENTE";
            
            pst.execute();
            pst.close();

        }catch(SQLException e){ 
            mensaje="NO SE PUDO GUARDAR CORRECTAMENTE: "+e.getMessage();
        } 
        return mensaje;
    }
    
    public String eliminarArticulo(String cod){
        Connection con = Conexion.getConnection();
        
        PreparedStatement pst =null;
        
        String sql = "DELETE FROM ARTICULO WHERE id= ?"; 
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, cod);
           // mensaje= "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
            
            if(cod.equals("")){
                mensaje= "NO SE ELIMINO NADA";
            }else{
                mensaje= "ELIMINADO CORRECTAMENTE";
            }

        }catch(SQLException e){ 
            mensaje="NO SE PUDO ELIMINAR CORRECTAMENTE: "+e.getMessage();
        }
        return mensaje;
    }
    
     public String modificarArticulo(Articulo art){
         
         Connection con = Conexion.getConnection();
         PreparedStatement pst =null;
        String sql = "UPDATE ARTICULO SET nombre=?,peso=?,valor=?,id_categoria=?,id_tipo=?"
                +" WHERE id= ?"; 
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, art.getNombre());
            pst.setFloat(2,art.getPeso());
            pst.setInt(3, art.getValor());
            pst.setString(4, art.getCodCat());
            pst.setString(5, art.getCodTipo());
            
            pst.setString(6, art.getID());
            
            mensaje= "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        }catch(SQLException e){ 
            mensaje="NO SE PUDO MODIFICAR CORRECTAMENTE: "+e.getMessage();
        }
        return mensaje;
    }
    
     public ArrayList<Articulo> listarArticulo(){
         ArrayList listaArticulos = new ArrayList<Articulo>();
         Articulo articulo;
         
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        
       String sql = "SELECT a.id,a.nombre,a.PESO,a.VALOR,c.id as CATEGORIA,t.id as TIPO FROM articulo a,categoria c,tipo t \n" +
                "WHERE a.id_categoria = c.id and a.id_tipo = t.id ORDER BY id ASC";
       
        
        try{
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                
            while (rs.next()) {
               
               articulo = new Articulo(rs.getString("ID"),rs.getFloat("PESO"),rs.getInt("VALOR"),rs.getString("NOMBRE"),rs.getString("CATEGORIA"),rs.getString("TIPO"));
         
               listaArticulos.add(articulo);
            }
          
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, "NO SE PUDO LISTAR CORRECTAMENTE: "+e.getMessage());
        } 
        return listaArticulos;
    }
    
     public ArrayList<Articulo> listarArticuloIndispensables(){
         ArrayList listaArticulos = new ArrayList<Articulo>();
         Articulo articulo;
         
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        
       String sql = "SELECT a.id,a.nombre,a.PESO,a.VALOR,c.id as CATEGORIA,t.id as TIPO FROM articulo a,categoria c,tipo t\n" +
                    "WHERE a.id_categoria = c.id and a.id_tipo = t.id and t.nombre = 'INDISPENSABLE'";
       
        
        try{
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                
            while (rs.next()) {
               
               articulo = new Articulo(rs.getString("ID"),rs.getFloat("PESO"),rs.getInt("VALOR"),rs.getString("NOMBRE"),rs.getString("CATEGORIA"),rs.getString("TIPO"));
         
               listaArticulos.add(articulo);
            }
          
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, "NO SE PUDO LISTAR CORRECTAMENTE: "+e.getMessage());
        } 
        return listaArticulos;
    }
     
      public ArrayList<Articulo> listarArticuloNecesarios(){
         ArrayList listaArticulos = new ArrayList<Articulo>();
         Articulo articulo;
         
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        
       String sql = "SELECT a.id,a.nombre,a.PESO,a.VALOR,c.id as CATEGORIA,t.id as TIPO FROM articulo a,categoria c,tipo t\n" +
                    "WHERE a.id_categoria = c.id and a.id_tipo = t.id and t.nombre = 'NECESARIO'";
       
        
        try{
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                
            while (rs.next()) {
               
               articulo = new Articulo(rs.getString("ID"),rs.getFloat("PESO"),rs.getInt("VALOR"),rs.getString("NOMBRE"),rs.getString("CATEGORIA"),rs.getString("TIPO"));
         
               listaArticulos.add(articulo);
            }
          
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, "NO SE PUDO LISTAR CORRECTAMENTE: "+e.getMessage());
        } 
        return listaArticulos;
    }
     
     public  Articulo BuscarArticulo(String cod){
       Articulo articulo=null ;
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        String sql = "SELECT * FROM ARTICULO WHERE ID=?";
       
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cod);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                articulo = new Articulo(rs.getString("ID"),rs.getFloat("PESO"),rs.getInt("VALOR"),rs.getString("NOMBRE"),rs.getString("CATEGORIA"),rs.getString("TIPO"));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA "+ e.getMessage());
            
        }finally{
            try {
                if(con!=null){
                    con.close();
                    pst.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR "+ e.getMessage());
            }
        }  
        return articulo;
    } 
     
     
     
     
     
     
     
     
     
     
    
    public ArrayList<Categoria> listarCategorias(){
         ArrayList listaCategorias = new ArrayList<Categoria>();
         Categoria categoria;
         
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        
       String sql = "SELECT ID,NOMBRE FROM CATEGORIA ORDER BY ID ASC";
       
        
        try{
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                
            while (rs.next()) {
               
               categoria = new Categoria(rs.getString("ID"),rs.getString("NOMBRE"));
         
               listaCategorias.add(categoria);
            }
          
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, "NO SE PUDO LISTAR CAT CORRECTAMENTE: "+e.getMessage());
        } 
        return listaCategorias;
    }
    
     public ArrayList<Tipo> listarTipo(){
         ArrayList listatipos = new ArrayList<Tipo>();
         Tipo tipo;
         
        Connection con = Conexion.getConnection();
        PreparedStatement pst =null;
        
       String sql = "SELECT ID,NOMBRE FROM TIPO ORDER BY ID ASC";
       
        
        try{
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                
            while (rs.next()) {
               
               tipo = new Tipo(rs.getString("ID"),rs.getString("NOMBRE"));
         
               listatipos.add(tipo);
            }
          
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, "NO SE PUDO LISTAR TIPO CORRECTAMENTE: "+e.getMessage());
        } 
        return listatipos;
    }
    
    
    
    
}
