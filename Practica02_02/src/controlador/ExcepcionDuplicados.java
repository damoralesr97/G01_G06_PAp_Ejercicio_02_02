/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

/**
 *
 * @author DavidMorales
 */
public class ExcepcionDuplicados extends Exception {

    private GestionDato gD;
    
    public ExcepcionDuplicados(GestionDato gD) {
        this.gD=gD;
    }

    public ExcepcionDuplicados(String string) {
        super(string);
    }
    
    public boolean verificarAutor(Autor a){
        for(Autor au:this.gD.getAutorList()){
            if(a.getCedula().equals(au.getCedula()) || a.getCodigo()==au.getCodigo()){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarRevista(Revista r){
        for(Revista re:this.gD.getRevistaList()){
            if(r.getCodigo()==re.getCodigo()){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarArticulo(Articulo a){
        for(Articulo ar:this.gD.getArticuloList()){
            if(ar.getCodigoArticulo()==a.getCodigoArticulo()){
                return false;
            }
        }
    return true;
    }
}
