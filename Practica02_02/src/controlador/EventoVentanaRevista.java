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
        try{
            String numeroE,fechaP,titulo,codigo;
        
            numeroE=this.ventanaRevista.getTxtList().get(0).getText();
            fechaP=this.ventanaRevista.getTxtList().get(1).getText().replace("/", "");
            titulo=this.ventanaRevista.getTxtList().get(2).getText();
            codigo=this.ventanaRevista.getTxtList().get(3).getText();
        
            if(fechaP.length()<9){
                for(int i=0;i<fechaP.length();i++){
                    if(fechaP.charAt(i)<47 || fechaP.charAt(i)>58){
                       throw new ExcepcionFecha("Fecha Incorrecta");
                    }
                }  
            } else{
                throw new ExcepcionFecha("Fecha Incorrecta");
            }
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Revista revista= new Revista(Integer.parseInt(numeroE),fechaP,titulo,Integer.parseInt(codigo));
            
            if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
            File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
            archivo.createNewFile();
            ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaRevista.getgD());
            if(this.ventanaRevista.getgD().getRevistaList().size()==0){
                    this.ventanaRevista.getgD().cargarDatosListaRevista(archivo);
                    boolean bandera=eD.verificarRevista(revista);
                    if(bandera==true){
                        this.ventanaRevista.getgD().addRevista(revista);
                        this.ventanaRevista.getgD().escribirRevista(archivo, revista);
                        JOptionPane.showMessageDialog(null, "La revista se Registro en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaRevista.cargaDatosTabla(this.ventanaRevista.getgD().getRevistaList().size(), 4);
                        this.ventanaRevista.setDatos(datosTabla);
                        this.ventanaRevista.getModeloTabla().setDataVector(this.ventanaRevista.getDatos(),this.ventanaRevista.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Revista Registrada");
                    }
                    
            }else{
                boolean bandera1=eD.verificarRevista(revista);
                if(bandera1==true){
                   this.ventanaRevista.getgD().addRevista(revista);
                   this.ventanaRevista.getgD().escribirRevista(archivo, revista);
                   Object[][] datosTabla=this.ventanaRevista.cargaDatosTabla(this.ventanaRevista.getgD().getRevistaList().size(), 4);
                   this.ventanaRevista.setDatos(datosTabla);
                   this.ventanaRevista.getModeloTabla().setDataVector(this.ventanaRevista.getDatos(),this.ventanaRevista.getEncabezado());
                   JOptionPane.showMessageDialog(null, "Usuario Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);   
                }else{
                   throw new ExcepcionDuplicados("Revista Registrada");
                }       
            }
                    
                    
        }else{
               JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
        }
           
            
        }
        catch(ExcepcionDuplicados ae){
            JOptionPane.showMessageDialog(null, "La revista ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ae){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo o numero de edicion validos(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionFecha ae){
            JOptionPane.showMessageDialog(null, "Ingresar una fecha valida (Ejemplo:01/01/2010)", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(EventoVentanaRevista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
