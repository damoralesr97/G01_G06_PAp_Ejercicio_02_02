/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            
            Revista revista= new Revista(Integer.parseInt(numeroE),fechaP,titulo,Integer.parseInt(codigo));
            
            boolean bandera=false;
            for(Revista re:this.ventanaRevista.getgD().getRevistaList()){
                if(re.getCodigo()==(revista.getCodigo())){
                    bandera = true;
                    break;
                }
            }
            if(bandera==true){
                throw new ExcepcionDuplicados("La revista ya esta registrada");
            } else{
                this.ventanaRevista.getgD().addRevista(revista);
            }
            
        }
        catch(ExcepcionDuplicados ae){
            JOptionPane.showMessageDialog(null, "El autor ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ae){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo o numero de edicion validos(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionFecha ae){
            JOptionPane.showMessageDialog(null, "Ingresar una fecha valida (Ejemplo:01/01/2010)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
