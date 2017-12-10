/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Articulo;
import vista.VentanaArticulo;

/**
 *
 * @author bryam
 */
public class EventoVentanaArticulo implements ActionListener {

    private VentanaArticulo ventanaArticulo;

    public EventoVentanaArticulo(VentanaArticulo ventanaArticulo) {
        this.ventanaArticulo = ventanaArticulo;
    }

    public VentanaArticulo getVentanaArticulo() {
        return ventanaArticulo;
    }

    public void setVentanaArticulo(VentanaArticulo ventanaArticulo) {
        this.ventanaArticulo = ventanaArticulo;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String titulo,codigo,autor,revista;
        
        titulo=this.ventanaArticulo.getTxtList().get(0).getText();
        codigo=this.ventanaArticulo.getTxtList().get(1).getText();
        autor=this.ventanaArticulo.getTxtList().get(2).getText();
        revista=this.ventanaArticulo.getTxtList().get(3).getText();
        
        Articulo articulo= new Articulo(titulo,this.ventanaArticulo.getgD().buscarAutor(autor),codigo,this.ventanaArticulo.getgD().buscarRevista(revista));
        this.ventanaArticulo.getgD().addArticulo(articulo);
    
    }
    
}
