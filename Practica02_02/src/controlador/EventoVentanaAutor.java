/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Autor;
import vista.VentanaAutor;

/**
 *
 * @author bryam
 */
public class EventoVentanaAutor implements ActionListener {

    private VentanaAutor ventanaAutor;

    public EventoVentanaAutor(VentanaAutor ventanaAutor) {
        this.ventanaAutor = ventanaAutor;
    }

    public VentanaAutor getVentanaAutor() {
        return ventanaAutor;
    }

    public void setVentanaAutor(VentanaAutor ventanaAutor) {
        this.ventanaAutor = ventanaAutor;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        String nombre,codigo,cedula;
        
        nombre=this.ventanaAutor.getTxtList().get(0).getText();
        codigo=this.ventanaAutor.getTxtList().get(1).getText();
        cedula=this.ventanaAutor.getTxtList().get(2).getText();
        
        Autor autor=new Autor(nombre,Integer.parseInt(codigo),cedula);
        this.ventanaAutor.getgD().addAutor(autor);
        
        
        
    }
    
}
