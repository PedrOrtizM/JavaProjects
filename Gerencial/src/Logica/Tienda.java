package Logica;

import java.util.ArrayList;

/**
 * @author Pedro Ortiz M
 * @version 1.0
 * @created 20-nov.-2017 5:43:27 p. m.
 */
public class Tienda {

	private ArrayList<Inventario> productos;
	private String razonSocial;
	private String direccion;
	private ArrayList<Proveedor> proveedores;
	

	public Tienda(){

	}

    public ArrayList<Inventario> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Inventario> productos) {
        this.productos = productos;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

        
}//end Tienda