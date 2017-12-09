/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author paulo
 */
import controlador.EventoVentanaPrincipal;
import controlador.GestionDato;
import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class VentanaPrincipal extends JFrame
{
    private JDesktopPane escritorio;
    private JMenuBar barramenu;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList;
    private VentanaArticulo Ventanaarticulo;
    private VentanaAutor Ventanaautor;
    private VentanaRevista Ventanarevista;
    private GestionDato gd;

    public VentanaPrincipal(String titulo, int ancho, int alto, GestionDato gd) {
        super(titulo);
        this.setSize(ancho, alto);
        this.gd=gd;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciaComponentes();
        this.setVisible(true);
    }
    public void iniciaComponentes()
    {
        this.escritorio = new JDesktopPane();
        this.barramenu = new JMenuBar();
        
        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Resgistra Autor"));
        this.menuItemList.add(new JMenuItem("Registra Revista"));
        this.menuItemList.add(new JMenuItem("Registra Articulo"));   
      
            
        this.menuList = new ArrayList<JMenu>();
        this.menuList.add(new JMenu("Registro"));

      
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barramenu);
        
        //agrega los menu a la barra
        this.barramenu.add(this.menuList.get(0));

        
        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(1));
        this.menuList.get(0).add(this.menuItemList.get(2));   
        
      
        this.menuItemList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        
        
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarramenu() {
        return barramenu;
    }

    public void setBarramenu(JMenuBar barramenu) {
        this.barramenu = barramenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public VentanaArticulo getVentanaarticulo() {
        return Ventanaarticulo;
    }

    public void setVentanaarticulo(VentanaArticulo Ventanaarticulo) {
        this.Ventanaarticulo = Ventanaarticulo;
    }

    public VentanaAutor getVentanaautor() {
        return Ventanaautor;
    }

    public void setVentanaautor(VentanaAutor Ventanaautor) {
        this.Ventanaautor = Ventanaautor;
    }

    public VentanaRevista getVentanarevista() {
        return Ventanarevista;
    }

    public void setVentanarevista(VentanaRevista Ventanarevista) {
        this.Ventanarevista = Ventanarevista;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }
    
    
    
    
    
}
