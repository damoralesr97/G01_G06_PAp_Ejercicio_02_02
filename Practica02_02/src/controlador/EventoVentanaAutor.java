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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
        
        try{
            String nombre,codigo,cedula;
        
            nombre=this.ventanaAutor.getTxtList().get(0).getText().toUpperCase().replace(" ", "");
            codigo=this.ventanaAutor.getTxtList().get(1).getText();
            cedula=this.ventanaAutor.getTxtList().get(2).getText().toUpperCase();
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Autor autor=new Autor(nombre,Integer.parseInt(codigo),cedula);
        
            for(int i=0;i<nombre.length();i++){
                if(nombre.charAt(i)<64 || nombre.charAt(i)>91){
                    throw new ExcepcionSoloLetras("Solo letras");
                }
            }
            if(cedula.length()==10){
                for(int i=0;i<cedula.length();i++){
                    if(cedula.charAt(i)<47 || cedula.charAt(i)>58){
                       throw new ExcepcionCedula("Cedula Incorrecta");
                    }
                }  
            } else{
                throw new ExcepcionCedula("Cedula Incorrecta");
            }
        if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
            File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
            archivo.createNewFile();
            ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaAutor.getgD());
            if(this.ventanaAutor.getgD().getAutorList().size()==0){
                this.ventanaAutor.getgD().cargarDatosLista(archivo);
                boolean bandera=eD.verificarAutor(autor);
                if(bandera==true){
                    this.ventanaAutor.getgD().addAutor(autor);
                    this.ventanaAutor.getgD().escribirAutor(archivo, autor);
                }else{
                    throw new ExcepcionDuplicados("Usuario Registrado");
                }
                
                JOptionPane.showMessageDialog(null, "Usuario Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                }else{
                    boolean bandera1=eD.verificarAutor(autor);
                    if(bandera1==true){
                      this.ventanaAutor.getgD().addAutor(autor);
                        this.ventanaAutor.getgD().escribirAutor(archivo, autor);
                        JOptionPane.showMessageDialog(null, "Usuario Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);   
                    }else{
                        throw new ExcepcionDuplicados("Usuario Registrado");
                    }
                    
            }
                    
                    
        }else{
               JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
        }
    }
    catch(ExcepcionDuplicados ae){
            JOptionPane.showMessageDialog(null, "El autor ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    catch(ExcepcionSoloLetras ae){
            JOptionPane.showMessageDialog(null, "Ingresar solo letras", "Error", JOptionPane.ERROR_MESSAGE);
    }
    catch(NumberFormatException ae){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo valido(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
    }
    catch(ExcepcionCedula ae){
            JOptionPane.showMessageDialog(null, "Ingresar cedula valida", "Error", JOptionPane.ERROR_MESSAGE);
   } catch (IOException ex) {
            Logger.getLogger(EventoVentanaAutor.class.getName()).log(Level.SEVERE, null, ex);
    }   
        
}
    
}
