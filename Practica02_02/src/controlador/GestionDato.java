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
    
    public boolean addAspirante(Revista revista){
        return this.revistaList.add(revista);
    }
 
    public boolean addRector(Autor autor){
        return this.autorList.add(autor);
    }
    
    public boolean addUniversidad(Articulo arti){
        return this.articuloList.add(arti);
    }
    
}
