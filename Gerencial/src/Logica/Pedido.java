/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Pedro Ortiz M
 */
public class Pedido {
 
   
   private Date fecha;
   private Proveedor proveedor;
   private ArrayList<Integer>cantidad;
   private ArrayList<String>referencia;
   private int idPedido;

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

 
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

 


}
