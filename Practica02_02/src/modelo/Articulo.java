
package modelo;

/**
 *
 * @author Tatiana Cárdenas/
 */
public class Articulo {
    
    private String codigoArticulo;
    private Autor autorArticulo;
    private String tituloArticulo;
    private Revista revistaArticulo;

    public Articulo(String codigoArticulo, Autor autorArticulo, String tituloArticulo, Revista revistaArticulo) {
        this.codigoArticulo = codigoArticulo;
        this.autorArticulo = autorArticulo;
        this.tituloArticulo = tituloArticulo;
        this.revistaArticulo = revistaArticulo;
    }

   

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public Autor getAutorArticulo() {
        return autorArticulo;
    }

    public void setAutorArticulo(Autor autorArticulo) {
        this.autorArticulo = autorArticulo;
    }

    public String getTituloArticulo() {
        return tituloArticulo;
    }

    public void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo = tituloArticulo;
    }

    public Revista getRevistaArticulo() {
        return revistaArticulo;
    }

    public void setRevistaArticulo(Revista revistaArticulo) {
        this.revistaArticulo = revistaArticulo;
    }
    

    @Override
    public String toString() {
        return "Articulo{" + "codigoArticulo=" + codigoArticulo + ", autorArticulo=" + autorArticulo + ", tituloArticulo=" + tituloArticulo + '}';
    }
    
    
    
    
}
