/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Autor;

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
            if(a.getCedula().equals(au.getCedula())){
                return false;
            }
        }
    return true;
    }
}
