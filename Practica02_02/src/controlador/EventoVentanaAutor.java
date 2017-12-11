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
            
            for(int i=0;i<nombre.length();i++){
                if(nombre.charAt(i)<64 || nombre.charAt(i)>91){
                    throw new ExcepcionSoloLetras("Solo letras");
                }
            }
            if(cedula.length()<11){
                for(int i=0;i<cedula.length();i++){
                    if(cedula.charAt(i)<47 || cedula.charAt(i)>58){
                       throw new ExcepcionCedula("Cedula Incorrecta");
                    }
                }  
            } else{
                throw new ExcepcionCedula("Cedula Incorrecta");
            }
        
            Autor autor=new Autor(nombre,Integer.parseInt(codigo),cedula);
            
            boolean bandera=false;
            for(Autor au:this.ventanaAutor.getgD().getAutorList()){
                if(au.getCedula().equals(autor.getCedula())){
                    bandera = true;
                    break;
                }
            }
            if(bandera==true){
                throw new ExcepcionDuplicados("El autor ya esta registrado");
            } else{
                this.ventanaAutor.getgD().addAutor(autor);
            }
            
        
        
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
        
            if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
                File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
            }else{
                System.out.println("Se cancelo su opcion");
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
        }
        
        
        
        
        
        
        
        
    }
    
}
