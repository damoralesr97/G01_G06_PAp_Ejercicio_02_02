/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author paulo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelo.*;
public class GestionDato
{
    private List<Autor> autorList;
    private List<Articulo> articuloList;
    private List<Revista> revistaList;

    public GestionDato(List<Autor> autorList, List<Articulo> articuloList, List<Revista> revistaList) {
        this.autorList = autorList;
        this.articuloList = articuloList;
        this.revistaList = revistaList;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public List<Revista> getRevistaList() {
        return revistaList;
    }

    public void setRevistaList(List<Revista> revistaList) {
        this.revistaList = revistaList;
    }
    
    public boolean addRevista(Revista r){
        return this.revistaList.add(r);
    }
 
    public boolean addAutor(Autor au){
        return this.autorList.add(au);
    }
    
    public boolean addArticulo(Articulo ar){
        return this.articuloList.add(ar);
    }
    
    public Revista buscarRevista(String titulo){
        
        for(Revista r:this.getRevistaList()){
            if(r.getTitulo().equals(titulo)){
                return r;
            }
        }
    return null;
    }
    
    public Autor buscarAutor(String nombre){
        
        for(Autor a:this.getAutorList()){
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
    return null;
    }
    
    public boolean escribirAutor(File archivo,Autor a) throws IOException{
        
        FileWriter wr=new FileWriter(archivo.getAbsolutePath(),true);
        BufferedWriter br=new BufferedWriter(wr);
        
        br.append(a.getNombre()+"/"+a.getCodigo()+"/"+a.getCedula());
        br.newLine();
        
        br.close();
        return true; 
    }
    
    public boolean escribirRevista(File archivo,Revista r) throws IOException{
        
        FileWriter wr=new FileWriter(archivo.getAbsolutePath(),true);
        BufferedWriter br=new BufferedWriter(wr);
        
        br.append(r.getNumeroEdicion()+"/"+r.getFechaPublicacion()+"/"+r.getTitulo()+"/"+r.getCodigo());
        br.newLine();
        
        br.close();
        return true; 
    }
    
    public boolean escribirArticulo(File archivo,Articulo a) throws IOException{
        
        FileWriter wr=new FileWriter(archivo.getAbsolutePath(),true);
        BufferedWriter br=new BufferedWriter(wr);
        
        br.append(a.getCodigoArticulo()+"/"+a.getAutorArticulo().getCodigo()+"/"+a.getTituloArticulo()+"/"+a.getRevistaArticulo().getCodigo());
        br.newLine();
        
        br.close();
        return true; 
    }
    
    public void cargarDatosLista(File archivo) throws FileNotFoundException, IOException{
        
         FileReader fr= new FileReader(archivo.getAbsolutePath());
        BufferedReader br=new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null)
        {
            this.autorList.add(this.agregarAutor(linea));
        }
        br.close();
        
    }
    
    public Autor agregarAutor(String a){
        String[] temp=a.split("/");
        
        Autor au= new Autor(temp[0],Integer.parseInt(temp[1]),temp[2]);
    return au ;
    }
    
    public void cargarDatosListaRevista(File archivo) throws FileNotFoundException, IOException{
        
         FileReader fr= new FileReader(archivo.getAbsolutePath());
        BufferedReader br=new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null)
        {
            this.revistaList.add(this.agregarRevista(linea));
        }
        br.close();
        
    }
    
    public Revista agregarRevista(String r){
        String[] temp=r.split("/");
        
        
        
        Revista re= new Revista(Integer.parseInt(temp[0]),temp[1],temp[2],Integer.parseInt(temp[3]));
    return re ;
    }
    
    public void cargarDatosListaArticulo(File archivo) throws FileNotFoundException, IOException{
        
         FileReader fr= new FileReader(archivo.getAbsolutePath());
        BufferedReader br=new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null)
        {
            this.articuloList.add(this.agregarArticulo(linea));
        }
        br.close();
        
    }
    
    public Articulo agregarArticulo(String r){
        String[] temp=r.split("/");
   
        Articulo ar= new Articulo(Integer.parseInt(temp[0]),this.buscarAutor(Integer.parseInt(temp[1])),temp[2],this.buscarRevista(Integer.parseInt(temp[3])));
    return ar;
    }
    
    public Autor buscarAutor(int c){
        
        for(Autor a:this.getAutorList()){
            if(a.getCodigo()==c){
                return a;
            }
        }
    return null;
    }
    
     public Revista buscarRevista(int c){
        
        for(Revista r:this.getRevistaList()){
            if(r.getCodigo()==c){
                return r;
            }
        }
    return null;
    }
    
}
