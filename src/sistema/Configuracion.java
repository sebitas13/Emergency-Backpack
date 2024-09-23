/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import Controlador.Controlador;
import Modelo.Usuario;
import Estructuras.ArbolUsuario;
import Estructuras.ListaArticulos;
import Modelo.ArticuloDao;
import Vista.FrameIntGestionArticulo;
import Vista.FramePrincipal;


public class Configuracion {
    
    public static ListaArticulos listaArticulosIndispensables = new ListaArticulos();
    public static ListaArticulos listaArticulosNecesarios = new ListaArticulos();
  
    public static ArbolUsuario usuarios = new ArbolUsuario();
    public static Usuario usuario;
    
    /*public static Controlador getControlador (FramePrincipal vistaGestionArt,ArticuloDao artDao) {
        Controlador control = new Controlador(vistaGestionArt,artDao);
        return control;
    }
    */
      public static Controlador control = new Controlador();
      //public static ArticuloDao articuloDao = Controlador.getArticuloDao();
    
}
