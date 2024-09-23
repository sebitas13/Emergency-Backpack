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
public class Caja {

    private int pesoMaximo;
    private int pesoLibre;
    //private Articulo[] articulos;
    private ListaArticulos articulos;
    private int peso;
    private int valor;

    public Caja(int pesoMax) {
        this.pesoMaximo = pesoMax;
        this.articulos = new ListaArticulos();
        this.valor = 0;
        this.peso = 0;
        //this.pesoLibre=0;
    }

    public int getPesoLibre() {
        return pesoMaximo - peso;
    }

    public Articulo[] getArticulos() {

        Articulo[] articulos = new Articulo[this.articulos.getContador()];
        int i = 0;
        Articulo e = this.articulos.cab;
        while (e != null) {

            //OJO SE CREAN NUEVOS OBJETOS PARA EVITAR PROBLEMAS CON LA LISTA ENLAZADA
            articulos[i] = new Articulo(e.getID(), e.getPeso(), e.getValor(), e.getNombre(),e.getCodCat(),e.getCodTipo());

            e = e.getSgte();
            i++;

        }
        return articulos;

    }

    public int getPeso() {
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

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    //agrega un articulo a la caja
    public void agregarArticulo(Articulo e) {

        if (this.articulos.agregar(e)) {

            this.valor += e.getValor(); // aumenta el valor

            this.peso += e.getPeso(); // Aumenta el peso     

        }

    }

    public void clear() {
        this.peso = 0;
        this.valor = 0;
        this.articulos.vaciarArticulos();

    }

    public void eliminarElemento(Articulo e) {

        if (this.articulos.eliminarArticulo(e)) {

            this.peso -= e.getPeso(); //Reduce el peso
            this.valor -= e.getValor(); // reduce el valor

        }
    }

    public boolean existeElemento(Articulo e) {

        if (this.articulos.findArticulo(e.getID())) {
            //System.out.println(e.getNombre()+" Existe");
            return true;
        } else {
            // System.out.println(e.getNombre()+" no exite");
            return false;
        }
    }

    //muestra el contenido de la mochila
    public String toString() {
        String cadena = "";
        if (getPeso() == 0) {
            cadena = "ENTRA TODO O INTRODUCE MAS PESO";
        } else {

            cadena += this.articulos.getInfoArticulo();
            cadena += "Peso Mochila: " + getPesoMaximo() + "\n";
            cadena += "Peso Usado: " + getPeso() + "\n";
            cadena += "Peso Libre: " + getPesoLibre() + "\n";
            cadena += "Valor Total: " + getValor() + "\n";

        }
        return cadena;
    }

    //algoritmo recursivo 
    public static void llenarCaja(Caja c_base, Articulo[] elementos, boolean llena, Caja c_opt) {

        //si esta llena
        if (llena) {
            //compruebo si tiene mas beneficio que otra
            if (c_base.getValor() > c_opt.getValor()) {

                Articulo[] elementosMochBase = c_base.getArticulos();
                c_opt.clear();

                System.out.println(c_opt);

                //metemos los elementos
                for (Articulo e : elementosMochBase) {
                    if (e != null) {

                        c_opt.agregarArticulo(e);
                        //System.out.println(m_opt);
                    }

                }

            }

        } else {
            //Recorre los elementos
            for (int i = 0; i < elementos.length; i++) {
                //si existe el elemento
                // System.out.println("1er-> "+elementos[i].getNombre());
                if (!c_base.existeElemento(elementos[i])) {
                    //Si el peso de la mochila se supera, indicamos que esta llena
                    if (c_base.getPesoMaximo() >= c_base.getPeso() + elementos[i].getPeso()) {
                        c_base.agregarArticulo(elementos[i]); //añadimos
                        llenarCaja(c_base, elementos, false, c_opt);
                        c_base.eliminarElemento(elementos[i]); // lo eliminamos
                    } else {
                        llenarCaja(c_base, elementos, true, c_opt);
                    }

                }

            }

        }

    }

}
