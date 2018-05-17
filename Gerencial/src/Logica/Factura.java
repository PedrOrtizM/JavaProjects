package Logica;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Pedro Ortiz M
 * @version 1.0
 * @created 20-nov.-2017 5:43:27 p. m.
 */
public class Factura {

	private Cliente cliente;
	private Date fecha;
	private ArrayList<Venta> ventas;
	private double total;
	

	public Factura(){

	}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}//end Factura

