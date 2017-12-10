/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Revista;
import vista.VentanaRevista;

/**
 *
 * @author bryam
 */
public class EventoVentanaRevista implements ActionListener {

    private VentanaRevista ventanaRevista;

    public EventoVentanaRevista(VentanaRevista ventanaRevista) {
        this.ventanaRevista = ventanaRevista;
    }

    public VentanaRevista getVentanaRevista() {
        return ventanaRevista;
    }

    public void setVentanaRevista(VentanaRevista ventanaRevista) {
        this.ventanaRevista = ventanaRevista;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String numeroE,fechaP,titulo,codigo;
        
        numeroE=this.ventanaRevista.getTxtList().get(0).getText();
        fechaP=this.ventanaRevista.getTxtList().get(1).getText();
        titulo=this.ventanaRevista.getTxtList().get(2).getText();
        codigo=this.ventanaRevista.getTxtList().get(3).getText();
        
        Revista revista= new Revista(Integer.parseInt(numeroE),fechaP,titulo,codigo);
        this.ventanaRevista.getgD().addRevista(revista);
    }
    
}
