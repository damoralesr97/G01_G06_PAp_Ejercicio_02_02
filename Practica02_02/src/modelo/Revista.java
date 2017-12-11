/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Tatiana Cárdenas
 */
public class Revista {
    
    private int numeroEdicion;
    private String fechaPublicacion;
    private String titulo;
    private int codigo;

    public Revista(int numeroEdicion, String fechaPublicacion, String titulo, int codigo) {
        this.numeroEdicion = numeroEdicion;
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
        this.codigo = codigo;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Revista{" + "numeroEdicion=" + numeroEdicion + ", fechaPublicacion=" + fechaPublicacion + ", titulo=" + titulo + ", codigo=" + codigo + '}';
    }
    
    
    
    
}
