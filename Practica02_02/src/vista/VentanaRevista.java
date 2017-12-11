/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaRevista;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Autor;
import modelo.Revista;

/**
 *
 * @author paulo
 */
public class VentanaRevista extends JInternalFrame
{
     private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JComboBox combo;
    private JComboBox combo2;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD; 
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    
     public VentanaRevista(GestionDato gD) {
        super("Registrar Revista",true,true,true,true);
        this.gD=gD;
        this.iniciaComponentes();
        this.setSize(300, 300);
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public JComboBox getCombo2() {
        return combo2;
    }

    public void setCombo2(JComboBox combo2) {
        this.combo2 = combo2;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
     
    
     
     public void iniciaComponentes()
     {
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Numero de edicion"));
        this.etiList.add(new JLabel("Fecha de publicacion"));
        this.etiList.add(new JLabel("Nombre"));
        this.etiList.add(new JLabel("Codigo"));
        
        this.txtList= new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        this.boton = new JButton("Guardar");
        
         LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(5,2);
        JPanel panelSup = new JPanel(disenioSup);
        
        for(int i=0;i<4;i++)
        {
            panelSup.add(this.etiList.get(i));
            panelSup.add(this.txtList.get(i));
        }
        
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[4];
        this.encabezado[0] = "Numero de edición";
        this.encabezado[1] = "Fecha de publicacion";
        this.encabezado[2] = "Nombre";
        this.encabezado[3] = "Codigo";
        
        this.datos = this.cargaDatosTabla(this.gD.getRevistaList().size(),4);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
         this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
       
        this.boton.addActionListener(new EventoVentanaRevista(this));
        
        this.add(this.panelPrincipal);
     }
       public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Revista a:this.gD.getRevistaList())
        {
                retorno[i][0]=a.getNumeroEdicion();
                retorno[i][1]=a.getFechaPublicacion();
                retorno[i][2]=a.getTitulo();
                retorno[i][3]=a.getCodigo();
                i++;
            }
            
            
        return retorno;
    }
}
