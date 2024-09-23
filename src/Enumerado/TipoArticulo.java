/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumerado;

/**
 *
 * @author USUARIO
 */
public enum TipoArticulo {
    HIGIENE("1"),ABRIGO("2"),PRIMEROSAUX("3"),ALIMENTO("4"),COMUNICACION("5"),DIVERSOS("6"),ROPA("7");
    private String id;
    private TipoArticulo(String n) {
        this.id = n;
    }
    
    public String getID(){
        return id;
    }
    
}
