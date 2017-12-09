
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

public class Principal {

  
    public static void main(String[] args) 
    {
        List<Autor> autorList = new  ArrayList<Autor>();
        List<Revista> revistaList = new  ArrayList<Revista>();
        List<Articulo> articuloList = new  ArrayList<Articulo>();
        
        GestionDato gD = new GestionDato(autorList,articuloList,revistaList);
        VentanaPrincipal vP = new VentanaPrincipal("REVISTA",900,900,gD);
        vP.setVisible(true);
        
    }
    
}
