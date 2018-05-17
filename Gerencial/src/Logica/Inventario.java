package Logica;

/**
 * @author Pedro Ortiz M
 * @version 1.0
 * @created 20-nov.-2017 5:43:27 p. m.
 */
public class Inventario {

	private Producto producto;
	private int cantidad;


	public Inventario(){

	}

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}//end Inventario