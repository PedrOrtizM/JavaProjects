/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.Proveedor;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pedro Ortiz M
 */
public class DAOproveedor {

    private Proveedor proveedor;

    public DAOproveedor() {
    }

    public DAOproveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void registrar() {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();

        String ComandoSQL = "INSERT INTO proveedor (razonSocial,direccion,telefono,email) "
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);

            ps.setString(1, proveedor.getRazon_social());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmail());

            int aux = ps.executeUpdate();

            if (aux > 0) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR REGISTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRO");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOproducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Proveedor verificarProveedor(String razon) {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;

        try {
            String SQL = "SELECT * FROM proveedor WHERE razonSocial='" + razon + "'";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                Proveedor p = new Proveedor(rs.getString("razonSocial"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"));

                return p;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOproveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
