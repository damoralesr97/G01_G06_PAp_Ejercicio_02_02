/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
        
        
        JFileChooser guardar=new JFileChooser();
        JButton boton=new JButton();
        
        if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
            File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
        }else{
            System.out.println("Se cancelo su opcion");
        }
        
        
        
        
        
        
        
    }
    
}
