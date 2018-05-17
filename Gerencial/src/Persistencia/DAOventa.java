/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Ortiz M
 */
public class DAOventa {

    private Venta venta;

    public DAOventa() {
    }

    public DAOventa(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void registrarVenta() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        String ComandoSQL = "INSERT INTO venta (fecha,cedula,total) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);

            ps.setString(1, venta.getFecha().toString());
            ps.setString(2, venta.getCliente().getCedula());
            ps.setDouble(3, venta.getTotal());
            int aux = ps.executeUpdate();

            if (aux > 0) {

                //JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRO");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOproveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int obtenerIdVenta() {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        try {
            String SQL = "SELECT MAX(idVenta) FROM venta";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);
     
//               JOptionPane.showMessageDialog(null, rs.getString("MAX(idPedido)"));
                 if(rs.next()) return rs.getInt("MAX(idVenta)");
            

        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }
    public void registrarHas() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        boolean aux2=false;

        String ComandoSQL = "INSERT INTO producto_has_venta (referencia,idVenta,cantidad)"
                + "VALUES(?,?,?)";

        for (int i = 0; i < venta.getCantidad().size(); i++) {
            try {

                PreparedStatement ps = con.prepareStatement(ComandoSQL);
                ps.setString(1, venta.getReferencia().get(i));
                ps.setInt(2, venta.getIdVenta());
                ps.setInt(3, venta.getCantidad().get(i));

                int aux = ps.executeUpdate();

                if (aux > 0) {
                   aux2=true;
                    System.out.println("registrado");
                } else {
                    System.out.println("ERROR en el registro");

                }
            
            } catch (SQLException ex) {
                Logger.getLogger(DAOproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
                if(aux2){
                 JOptionPane.showMessageDialog(null, "VENTA REGISTRADO");
                }

        }
    }
    
    public int obtenerCantidad(String referencia){
    
        
           Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        try {
            String SQL = "SELECT cantidad FROM inventario WHERE referencia='"+referencia+"'";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);
            
            System.out.println(rs.toString());
//               JOptionPane.showMessageDialog(null, rs.getString("MAX(idPedido)"));
                 if(rs.next()) return rs.getInt("cantidad");
            

        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    
    
    
    
    
    }

}
