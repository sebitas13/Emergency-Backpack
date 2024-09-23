/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Estructuras.ListaArticulos;

/**
 *
 * @author USUARIO
 */
public class Mochila {
    
    private float pesoMaximo;
    private float pesoLibre;
    //private Articulo[] articulos;
    private ListaArticulos articulos;
    private float peso;
    private int valor;
 
    public Mochila(int peso) {
        this.pesoMaximo = peso;
        this.articulos = new ListaArticulos();
        this.valor = 0;
        this.peso = 0;
        //this.pesoLibre=0;
    }
 
    public float getPesoLibre(){
        
        return pesoMaximo-peso;
        
    }

    public ListaArticulos getArticulos() {
        return articulos;
    }
    
    
    
    public Articulo[] getArticulosM(){
        
        Articulo[] articulos = new Articulo[this.articulos.getContador()];
            int i=0;   
            Articulo e = this.articulos.cab;
                while (e != null) {

                    //OJO SE CREAN NUEVOS OBJETOS PARA EVITAR PROBLEMAS CON LA LISTA ENLAZADA
                    articulos[i] = new Articulo(e.getID(), e.getPeso(), e.getValor(), e.getNombre(),e.getCodCat(),e.getCodTipo());

                    e = e.getSgte();
                    i++;
                   
                   
                }
                return  articulos;
        
    }
 
     public float getPeso() {
       return peso;
    }
     
    public void setPeso(int peso) {
        this.peso = peso;
    }
 
    public int getValor() {
        return valor;
    }
 
    public void setValor(int valor) {
        this.valor = valor;
    }
 
    public float getPesoMaximo() {
        return pesoMaximo;
    }
 
    public void setPesoMaximo(float pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
 
   
    public void agregarArticulo(Articulo e) {
 
        
            if (this.articulos.agregar(e)) {
                
                this.valor+=e.getValor(); // aumenta el valor
                
                this.peso+=e.getPeso(); // Aumenta el piso

               
            }
        
 
    }
 
    
    public void clear() {
        this.peso=0;
        this.valor=0;
        this.articulos.vaciarArticulos();
        
    }
 
    
    public void eliminarElemento(Articulo e) {
        
            if (this.articulos.eliminarArticulo(e)) {
               
                this.peso-=e.getPeso(); //Reduce el peso
                this.valor-=e.getValor(); // reduce el valor
                
            }
        
    }
     
    
    public boolean existeElemento(Articulo e) {
       
         if(this.articulos.findArticulo(e.getID())){
             //System.out.println(e.getNombre()+" Existe");
             return true;
         }else{
            // System.out.println(e.getNombre()+" no exite");
             return false;
         }
    }
 
   
    public String toString() {
        String cadena="",pm;
        if(getPeso()==0){
        }else{
            
        //cadena+= this.articulos.getInfoArticulo();
        if(this.pesoMaximo!=8){
            pm = "Peso Caja ";
        }else{
            pm = "Peso Mochila ";
        }
        
        cadena+=pm + getPesoMaximo()+"\n";
        cadena+="Peso Usado: " + getPeso()+"\n";
        cadena+="Peso Libre: " + getPesoLibre()+"\n";
        cadena+="Valor Total: " + getValor()+"\n";
        cadena+="Numero de articulos: " + this.articulos.getContador()+"\n";
            
        }
         return cadena;
    }
 
   
    
    
    public static void llenarMochila(Mochila m_base, Articulo[] elementos, boolean llena, Mochila m_opt) {
      //si esta llena
      //caso base
      if (llena) {
          //compruebo si tiene mas beneficio que otra
          if (m_base.getValor() > m_opt.getValor()) {
 
              //entonces pasamos lo elementos de la mochila base al nuevo optimo
              
              Articulo[] elementosMochBase = m_base.getArticulosM();
              m_opt.clear();

              //metemos los elementos
              for (Articulo e : elementosMochBase) {
                  if (e != null) {
                      
                      m_opt.agregarArticulo(e);
                  }
              }
          }
 
      } else {
          //Recorre los elementos
          for (int i = 0; i < elementos.length; i++) {
              //si existe el elemento
         
              if (!m_base.existeElemento(elementos[i])) {
                  
                  //Si el peso de la mochila supera el peso maximo
                  if (m_base.getPesoMaximo() >= m_base.getPeso() + elementos[i].getPeso()) {
                      m_base.agregarArticulo(elementos[i]); //añadimos
                      llenarMochila(m_base, elementos, false, m_opt);
                      
                      m_base.eliminarElemento(elementos[i]); // lo sacamos para que siga realizando combinaciones
                  } else {
                      //cuando ya esta sobrecargada la mochila
                      llenarMochila(m_base, elementos, true, m_opt);
                  }
 
              }
 
          }
 
      }
 
  }
        
    
}
    

