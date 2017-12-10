/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Autor;

/**
 *
 * @author paulo
 */
public class VentanaAutor extends JInternalFrame
{
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    
    
    public VentanaAutor(GestionDato gD) {
        super("Registrar Autor",true,true,true,true);
        this.gD=gD;
        this.iniciaComponentes();
        this.setSize(500, 500);
    }

   
   
     public void iniciaComponentes()
     {
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Nombre"));
        this.etiList.add(new JLabel("Codigo"));
        this.etiList.add(new JLabel("Cedula"));
 
        
        this.txtList= new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.boton = new JButton("Guardar");
        
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(4,2);
        JPanel panelSup = new JPanel(disenioSup);
        
        for(int i=0;i<3;i++)
        {
            panelSup.add(this.etiList.get(i));
            panelSup.add(this.txtList.get(i));
        }
        
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[3];
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Codigo";
        this.encabezado[2] = "Cedula";

        
        
        this.datos = this.cargaDatosTabla(this.gD.getAutorList().size(),3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
        //poner que realiza el boton
      //this.boton.addActionListener(new EventoVentanaAspirante(this));
        
        this.add(this.panelPrincipal);
        
     }
     
     public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Autor a:this.gD.getAutorList())
        {

                retorno[i][0]=a.getNombre();
                retorno[i][1]=a.getCodigo();
                retorno[i][2]=a.getCedula();
                i++;
            }
            
            
        return retorno;
    }
}