/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
        try{
            String titulo,codigo,autor,revista;
        
            titulo=this.ventanaArticulo.getTxtList().get(0).getText();
            codigo=this.ventanaArticulo.getTxtList().get(1).getText();
            autor=this.ventanaArticulo.getCombo().getSelectedItem().toString();
            revista=this.ventanaArticulo.getCombo2().getSelectedItem().toString();
            
            Articulo articulo= new Articulo(Integer.parseInt(codigo),this.ventanaArticulo.getgD().buscarAutor(autor),titulo,this.ventanaArticulo.getgD().buscarRevista(revista));
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            
             if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
                 File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
                 archivo.createNewFile();
                 ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaArticulo.getgD());
                 if(this.ventanaArticulo.getgD().getArticuloList().size()==0){
                     this.ventanaArticulo.getgD().cargarDatosListaArticulo(archivo);
                     boolean bandera=eD.verificarArticulo(articulo);
                     if(bandera==true){
                         this.ventanaArticulo.getgD().addArticulo(articulo);
                         this.ventanaArticulo.getgD().escribirArticulo(archivo, articulo);
                         JOptionPane.showMessageDialog(null, "El Articulo se Registro en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                         Object[][] datosTabla=this.ventanaArticulo.cargaDatosTabla(this.ventanaArticulo.getgD().getArticuloList().size(), 4);
                         this.ventanaArticulo.setDatos(datosTabla);
                         this.ventanaArticulo.getModeloTabla().setDataVector(this.ventanaArticulo.getDatos(),this.ventanaArticulo.getEncabezado());
                     }else{
                         throw new ExcepcionDuplicados("Articulo Registrado");
                     }
                 }else{
                      boolean bandera1=eD.verificarArticulo(articulo);
                     if(bandera1==true){
                         this.ventanaArticulo.getgD().addArticulo(articulo);
                         this.ventanaArticulo.getgD().escribirArticulo(archivo, articulo);
                         JOptionPane.showMessageDialog(null, "El Articulo se Registro en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                         Object[][] datosTabla=this.ventanaArticulo.cargaDatosTabla(this.ventanaArticulo.getgD().getArticuloList().size(), 4);
                         this.ventanaArticulo.setDatos(datosTabla);
                         this.ventanaArticulo.getModeloTabla().setDataVector(this.ventanaArticulo.getDatos(),this.ventanaArticulo.getEncabezado());
                     }else{
                         throw new ExcepcionDuplicados("Articulo Registrado");
                     }
                 }
             }
            
            
        }
        
        catch(NumberFormatException ae){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo valido(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionDuplicados ae){
            JOptionPane.showMessageDialog(null, "El articulo ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(EventoVentanaArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
}
