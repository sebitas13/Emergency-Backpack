    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Articulo {
    
    private String ID;
    private float peso;
    private int valor;
    private String nombre;
    private Articulo sgte;
    private String codCat;
    private String codTipo;
    private boolean elegigo;
    
 
    public Articulo(String ID,float peso, int valor,String nombre,String codCat,String codTipo) {
        this.ID=ID;
        this.peso = peso;
        this.valor = valor;
        this.nombre=nombre;
        this.sgte=null;
        this.codCat=codCat;
        this.elegigo=false;
        this.codTipo=codTipo;
    }

    public String getID() {
        return ID;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

   
 
    
    
    public float getPeso() {
        return peso;
    }
 
    public void setPeso(float peso) {
        this.peso = peso;
    }
 
    public int getValor() {
        return valor;
    }
 
    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Articulo getSgte() {
        return sgte;
    }

    public void setSgte(Articulo sgte) {
        this.sgte = sgte;
    }

    public boolean isElegigo() {
        return elegigo;
    }

    public void setElegigo(boolean elegigo) {
        this.elegigo = elegigo;
    }
    
    
 
    @Override
    public String toString(){
        return "Articulo: "+nombre+","+" Peso: "+peso+","+" Valor: "+valor;
    }
     
    
    
}
