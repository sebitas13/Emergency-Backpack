/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.ArticuloDao;
import Modelo.Categoria;
import Modelo.Tipo;
import Vista.FrameIntGestionArticulo;
import Vista.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class Controlador implements ActionListener{
    DefaultTableModel modeloT ;
    
    FrameIntGestionArticulo vistaGestionArt;
    private static  ArticuloDao artDao = null;
    FramePrincipal vistaPrincipal;
    
    public Controlador(){
        this.artDao = new ArticuloDao();
    }
    
  
    
    public void setFramePrincipal(FramePrincipal vistaPrincipal){
         this.vistaPrincipal=vistaPrincipal;
     //  this.artDao=artDao;
        this.vistaPrincipal.itemMochila.addActionListener(this);
        this.vistaPrincipal.itemCaja.addActionListener(this);
    }
    
    public void setFrameGestion(FrameIntGestionArticulo vistaGestionArt){
        this.vistaGestionArt = vistaGestionArt;
        this.vistaGestionArt.btnAgregar.addActionListener(this);
        this.vistaGestionArt.btnListar.addActionListener(this);
        this.vistaGestionArt.btnEliminar.addActionListener(this);
        this.vistaGestionArt.btnModificar.addActionListener(this);
        this.vistaGestionArt.btnInicializar.addActionListener(this);
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
        
        
        if(vistaGestionArt != null){
            
            
            if(e.getSource() == vistaGestionArt.btnListar ){
              llenarTabla(this.vistaGestionArt.tablaDatos);
              
         }else if(e.getSource() == vistaGestionArt.btnAgregar){
               try {
               String id = vistaGestionArt.txtID.getText();
               String nombre = vistaGestionArt.txtNombre.getText();
               String peso = vistaGestionArt.txtPeso.getText();
               String valor = vistaGestionArt.txtValor.getText();
               String cat = vistaGestionArt.txtCategoria.getText();
               String tipo = vistaGestionArt.txtTipo.getText();
               String rptaRegistro = artDao.agregarArticulo(new Articulo(id, Float.parseFloat(peso), Integer.parseInt(valor), nombre, cat, tipo));
               JOptionPane.showMessageDialog(null, rptaRegistro);
                 
                 
             } catch (Exception a) {
                 JOptionPane.showMessageDialog(null, a.getMessage());
             }
         }else if(e.getSource() == vistaGestionArt.btnEliminar){
             String id = vistaGestionArt.txtID.getText();
              String rptaRegistro = artDao.eliminarArticulo(id); // Lo elimina de la BD, pero no de la Lista Global
               JOptionPane.showMessageDialog(null, rptaRegistro);
         }else if(e.getSource() == vistaGestionArt.btnModificar){
             
             try {
                 
                 String id = vistaGestionArt.txtID.getText();
                 String nombre = vistaGestionArt.txtNombre.getText();
               String peso = vistaGestionArt.txtPeso.getText();
               String valor = vistaGestionArt.txtValor.getText();
               String cat = vistaGestionArt.txtCategoria.getText();
               String tipo = vistaGestionArt.txtTipo.getText();
               System.out.println("TIPO: "+tipo);
              String rptaModificar = artDao.modificarArticulo(new Articulo(id, Float.parseFloat(peso), Integer.parseInt(valor), nombre, cat, tipo));
               JOptionPane.showMessageDialog(null, rptaModificar);
                 
             } catch (Exception a) {
                 JOptionPane.showMessageDialog(null, a.getMessage());
             }
             
         }else if(e.getSource() == vistaGestionArt.btnInicializar){
            llenarComboCat(this.vistaGestionArt.cboCategoria);  
            llenarComboTipo(this.vistaGestionArt.cboTipo);
         }
                
        }
        
         
        if(vistaPrincipal!=null){
             
            
            if(e.getSource() == vistaPrincipal.itemMochila){
                Configuracion.listaArticulosIndispensables.vaciarArticulos();
                
                ArrayList<Articulo> lista = this.artDao.listarArticuloIndispensables();

                for(Articulo b : lista){
                     Configuracion.listaArticulosIndispensables.agregar(b);
                        
                }
              
            }
            
            if(e.getSource() == vistaPrincipal.itemCaja){
                Configuracion.listaArticulosNecesarios.vaciarArticulos();
                ArrayList<Articulo> lista = this.artDao.listarArticuloNecesarios();

                for(Articulo b : lista){
                     Configuracion.listaArticulosNecesarios.agregar(b);

                }
             
            }
            
            
        }
        
       
       
        
    }
    
    public void llenarTabla(JTable tablaD ){
        
        try {
          

           modeloT = (DefaultTableModel) tablaD.getModel();
           modeloT.getDataVector().clear();
    

           Object[] columna = new Object[6];

           
           ArrayList<Articulo> lista = this.artDao.listarArticulo();

           for(int i=0;i<lista.size();i++){
               
               columna[0] = lista.get(i).getID();
               columna[1] = lista.get(i).getNombre();
               columna[2] = lista.get(i).getPeso();
               columna[3] = lista.get(i).getValor();
               columna[4] = lista.get(i).getCodCat();
               columna[5] = lista.get(i).getCodTipo();

               modeloT.addRow(columna);
           }
           
             
           tablaD.setModel(modeloT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
       
        
    }
    
    public void llenarComboCat(JComboBox cat){
        ArrayList<Categoria> lista = this.artDao.listarCategorias();
         cat.removeAllItems();
        for(Categoria a : lista){
            cat.addItem(a);
           
        }
         
    }
    
    public void llenarComboTipo(JComboBox tipo){
        ArrayList<Tipo> lista = this.artDao.listarTipo();
         tipo.removeAllItems();
        for(Tipo a : lista){
            tipo.addItem(a);
         
        }
         
    }
    
    
    
}
