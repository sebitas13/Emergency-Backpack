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
public class Tipo {
    
    String codTipo;
    String desTipo;

    public Tipo(String codTipo, String desTipo) {
        this.codTipo = codTipo;
        this.desTipo = desTipo;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    public String getDesTipo() {
        return desTipo;
    }

    public void setDesTipo(String desTipo) {
        this.desTipo = desTipo;
    }

    @Override
    public String toString() {
        return this.desTipo;
    }

    
    
    
    
}
