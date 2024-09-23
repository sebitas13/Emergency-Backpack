/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Modelo.Articulo;
import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class ListaArticulos {

    public Articulo cab;
    int contador;

    public ListaArticulos() {

        cab = null;

        contador = 0;
    }

    
    public Articulo[] getArticulos() {
        
        Articulo[] articulos = new Articulo[contador];
            int i=0;   
            Articulo e = this.cab;
                while (e != null) {
                    articulos[i] = new Articulo(e.getID(), e.getPeso(), e.getValor(), e.getNombre(),e.getCodCat(),e.getCodTipo());
                    e = e.getSgte();
                    i++;         
                }
                return  articulos; 
    }
    
    
    
    public int getContador() {
        return contador;
    }

    public boolean agregar(Articulo p) {

        boolean retorno = false;
        Articulo aux = cab;
        if (p != null) {

            if (!this.findArticulo(p.getID())) {

                if (cab == null) {
                    cab = p;

                } else {
                   /** p.setSgte(cab);
                    cab = p;*/
                    while(aux.getSgte()!=null){
			aux = aux.getSgte();
                    }
			aux.setSgte(p);
			p.setSgte(null); // esta demas?	
                    
                }
                retorno = true;
            } else {
               // System.out.println("ya existe"+p.getNombre());
            }
            contador++;
        }

        return retorno;
    }

    
    
    
  public boolean findArticulo(String ID) {
        boolean encontrado = false;
        boolean retorno = false;
        Articulo recorre = cab;

        while (recorre != null && !encontrado) {

            if (recorre.getID().equals(ID)) {
                encontrado = true;
                retorno = true;
            } else {
                recorre = recorre.getSgte();
            }

        }

        return retorno;
    }
  
  
     public Articulo obtenerArticulo(String ID) {
        boolean encontrado = false;
        Articulo retorno = null;

        if (cab == null) {
          //  System.out.println("lista vacia");
        } else {
            Articulo aux = cab;
            while (aux != null && !encontrado) {
                if (ID.equals(aux.getID())) {
                    retorno = aux;
                    encontrado = true;
                } else {
                    aux = aux.getSgte();
                }
            }

        }
        return retorno;
    }
  
  
  
    public boolean eliminarProductoPorID(String ID) {

        boolean encontre = false;
        boolean retorno = false;

        Articulo recorre = cab;
        Articulo anterior = null;

        if (cab == null) {
          //  System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getID().equals(ID)) {
                    
                    if (recorre == cab) {
                        cab = cab.getSgte();
                    } else {
                        anterior.setSgte(recorre.getSgte());
                    }
                    encontre = true;
                    contador--;
                }
                anterior = recorre;
                recorre = recorre.getSgte();
            }
           // System.out.println("Producto dado de baja");
        }

        return retorno;

    }

     public boolean eliminarArticulo(Articulo a) {

        boolean encontre = false;
        boolean result =false;
       //  System.out.println("nombre: "+a.getNombre());
        Articulo recorre = cab;
        Articulo anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getID().equals(a.getID())) {
                    
                    if (recorre == cab) {
                        cab = cab.getSgte();
                    } else {
                        anterior.setSgte(recorre.getSgte());
                    }
                    encontre = true;
                       result=true;
                    contador--;
                }
                anterior = recorre;
                recorre = recorre.getSgte();
            }
         //   System.out.println("Producto dado de baja");
        }

        return result;

    }
    
     
     public boolean ModificarArticulo(Articulo p) {
        Articulo aux;
        boolean retorno = false;

        boolean encontrado = false;
        if (cab == null) {

        } else {
            aux = cab;
            while (aux != null && !encontrado) {
                if (aux.getID().equalsIgnoreCase(p.getID())) {
                    retorno = true;
                    encontrado = true;
                    aux.setNombre(p.getNombre());
                    aux.setPeso(p.getPeso());
                    aux.setValor(p.getValor());
                    aux.setCodCat(p.getCodCat());
                    
                    System.out.println("Modificado");
                } else {
                    aux = aux.getSgte();
                }
            }

        }
        return retorno;

    }
     
    
    
    public void vaciarArticulos() {

        
        cab = null;
        /*Articulo anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null) {

                if (recorre == cab) {
                    cab = cab.getSgte();
                } else {
                    anterior.setSgte(recorre.getSgte());
                }

                this.contador--;

                anterior = recorre;
                recorre = recorre.getSgte();
            }
        }*/
       this.contador =0;
    }
    
     public String getInfoArticulo() {
        //String[][] retorno = null;

        String result="";
        int i = 0;

        Articulo aux;
        if (cab == null) {
            System.out.println("Lista vacia");

        } else {
            aux = cab;
            while (aux != null) {

                result += aux.toString()+"\n";

                //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                aux = aux.getSgte();
                i++;
            }
        }

        return result;
    }

    
     public String[][] getMatrizProductoPorCategoria(String cat) {
        
        int i = 0;

        int cant = 0;
        Articulo aux;
        aux = cab;
        while (aux != null) {
            if (aux.getCodCat().equals(cat) && !aux.isElegigo()) {
                cant++;
            }
            aux = aux.getSgte();
        }

        String[][] result = new String[cant][5];

        if (cab == null) {
            System.out.println("Lista vacia");

        } else {
            aux = cab;
            while (aux != null) {
                if (aux.getCodCat().equals(cat) && !aux.isElegigo()) {
                 
               // result[i][0] = String.valueOf(Configuracion.listaArticulosG.posicionDeProducto(aux) + 1);
                result[i][0] = aux.getID();
                result[i][1] = aux.getNombre();
                result[i][2]  = aux.getCodCat();
                
                result[i][3] = String.valueOf(aux.getPeso());
                result[i][4] = String.valueOf(aux.getValor());
                    i++;
                }

                
                aux = aux.getSgte();
              
            }
        }

        return result;
    }
     
      
                

      public String[] getTituloProducto() {
        String[] retorno = null;

        String[] result = new String[5];

       // result[0] = "Pos:";
        result[0] = "ID";
        result[1] = "NOMBRE";
        result[2] = "CATEOGRIA";
        result[3] = "PESO";
        result[4] = "VALOR";

        retorno = result;

        return retorno;
    }
      
      
      public String[][] getMatrizArticulos() {
        //String[][] retorno = null;

        String[][] result = new String[this.contador][5];
        int i = 0;

        Articulo aux;
        if (cab == null) {
            System.out.println("Lista vacia");

        } else {
            aux = cab;
            while (aux != null) {

                result[i][0] = aux.getID();
                result[i][1] = aux.getNombre();
                result[i][2]  = aux.getCodCat();
                
                result[i][3] = String.valueOf(aux.getPeso());
                result[i][4] = String.valueOf(aux.getValor());
                    
                aux = aux.getSgte();
                i++;
            }
        }

        return result;
    }

      
     
     
     
        public int posicionDeProducto(Articulo c) {
        int result = 0;
        int i = 0; //this.cantidadClientes-1;
        Articulo aux;
        aux = cab;

        if (aux == null) {
            System.out.println("Lista vacia");
        } else {

            while (aux != null) {
                if (c.equals(aux)) {
                    result = i;
                    break;
                }
                aux = aux.getSgte();
                i++;
            }
        }

        return result;
    }
      
        
       public void articulosDisponibles() {
        
        int i = 0; //this.cantidadClientes-1;
        Articulo aux;
        aux = cab;

        if (aux == null) {
            System.out.println("Lista vacia");
        } else {

            while (aux != null) {
                aux.setElegigo(false);
                aux = aux.getSgte();
                i++;
            }
        }

       
    } 
      
}
