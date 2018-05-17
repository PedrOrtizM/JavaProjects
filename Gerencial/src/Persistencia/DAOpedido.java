/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Pedido;
import java.sql.Connection;
import java.sql.Date;
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
public class DAOpedido {

    private Pedido pedido;

    public DAOpedido() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void registrarPedido() {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();

        String ComandoSQL = "INSERT INTO pedido (fecha,razonSocial) "
                + "VALUES(?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);

            ps.setString(1, pedido.getFecha().toString());
            ps.setString(2, pedido.getProveedor().getRazon_social());

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

    public int obtenerIdPedido() {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        try {
            String SQL = "SELECT MAX(idPedido) FROM PEDIDO";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);

//               JOptionPane.showMessageDialog(null, rs.getString("MAX(idPedido)"));
            if (rs.next()) {
                return rs.getInt("MAX(idPedido)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

    public void registrarHas() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        boolean aux2 = false;

        String ComandoSQL = "INSERT INTO pedido_has_producto (cantidad,idPedido,referencia)"
                + "VALUES(?,?,?)";

        for (int i = 0; i < pedido.getCantidad().size(); i++) {
            try {

                PreparedStatement ps = con.prepareStatement(ComandoSQL);
                ps.setInt(1, pedido.getCantidad().get(i));
                ps.setInt(2, pedido.getIdPedido());
                ps.setString(3, pedido.getReferencia().get(i));

                int aux = ps.executeUpdate();

                if (aux > 0) {
                    aux2 = true;
                    System.out.println("registrado");
                    actualizarInventario(pedido.getReferencia().get(i), pedido.getCantidad().get(i));
                } else {
                    System.out.println("ERROR en el registro");

                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aux2) {
                JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO");

            }

        }
    }

    private void actualizarInventario(String referencia, int cantidad) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        try {
            String SQL = "SELECT cantidad FROM inventario WHERE referencia='" + referencia + "'";
            st = con.createStatement();
            

            ResultSet rs = st.executeQuery(SQL);
            int cantidadActual = 0;
//               JOptionPane.showMessageDialog(null, rs.getString("MAX(idPedido)"));
            if (rs.next()) {
                cantidadActual = rs.getInt("cantidad");
                cantidadActual += cantidad;
                
                System.out.println("CANTIDAD ACTUAL: "+cantidadActual);
                String SQL2 = "UPDATE inventario SET cantidad='"+cantidadActual+"' WHERE referencia='" + referencia + "'";
                st = con.createStatement();
              
                System.out.println(st.executeUpdate(SQL2));

               
               


            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
