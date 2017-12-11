
package modelo;

/**
 *
 * @author Tatiana Cárdenas/
 */
public class Articulo {
    
    private int codigoArticulo;
    private Autor autorArticulo;
    private String tituloArticulo;
    private Revista revistaArticulo;

    public Articulo(int codigoArticulo, Autor autorArticulo, String tituloArticulo, Revista revistaArticulo) {
        this.codigoArticulo = codigoArticulo;
        this.autorArticulo = autorArticulo;
        this.tituloArticulo = tituloArticulo;
        this.revistaArticulo = revistaArticulo;
    }

   

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
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
