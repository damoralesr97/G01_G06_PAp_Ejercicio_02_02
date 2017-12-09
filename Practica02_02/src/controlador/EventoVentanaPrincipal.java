/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaArticulo;
import vista.VentanaAutor;
import vista.VentanaPrincipal;
import vista.VentanaRevista;

/**
 *
 * @author paulo
 */
public class EventoVentanaPrincipal implements ActionListener
{
     private VentanaPrincipal ventanaPrincipal;

    public EventoVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

   

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
     
     
     
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(0))){
            VentanaAutor vAU = new VentanaAutor (this.ventanaPrincipal.getGd());
            vAU.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vAU);
        }
       
       if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(1))){
            VentanaRevista vR = new VentanaRevista(this.ventanaPrincipal.getGd());
            vR.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vR);
        }
       
         if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(2))){
            VentanaArticulo vAR = new VentanaArticulo (this.ventanaPrincipal.getGd());
            vAR.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vAR);
        }
         
       
        
        
    }
}
