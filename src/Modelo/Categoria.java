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
public class Categoria {
    
    String codCategoria;
    String desCategoria;

    public Categoria(String codCategoria, String desCategoria) {
        this.codCategoria = codCategoria;
        this.desCategoria = desCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    @Override
    public String toString() {
        return desCategoria;
    }
    
    
    
    
}
