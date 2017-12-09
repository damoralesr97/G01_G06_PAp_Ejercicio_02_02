
package modelo;

/**
 *
 * @author Tatiana Cárdenas
 */
public class Autor {
    
    private String nombre;
    private String codigo;
    private String cedula;

    public Autor(String nombre, String codigo, String cedula) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", codigo=" + codigo + ", cedula=" + cedula + '}';
    }
    
    
    
    
}
