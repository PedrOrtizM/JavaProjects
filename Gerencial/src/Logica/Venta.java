package Logica;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Pedro Ortiz M
 * @version 1.0
 * @created 20-nov.-2017 5:43:27 p. m.
 */
public class Venta {

   private Date fecha;
   private Cliente cliente;
   private ArrayList<Integer>cantidad;
   private ArrayList<String>referencia;
   private int idVenta;
   private Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public Venta() {
        cantidad = new ArrayList<>();
        referencia = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<String> getReferencia() {
        return referencia;
    }

    public void setReferencia(ArrayList<String> referencia) {
        this.referencia = referencia;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

	
	
}//end Venta