/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author DavidMorales
 */
public class ExcepcionDuplicados extends Exception {

    public ExcepcionDuplicados() {
    }

    public ExcepcionDuplicados(String string) {
        super(string);
    }
    
}
