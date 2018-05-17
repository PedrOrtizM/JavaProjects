/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.Cliente;

/**
 *
 * @author Pedro Ortiz M
 */
public class DAOcliente {

    private Cliente cliente;

    public DAOcliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DAOcliente() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrar() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();

        String ComandoSQL = "INSERT INTO cliente (nombre,cedula,telefono,genero) "
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getGenero());

            int aux = ps.executeUpdate();

            if (aux > 0) {
                JOptionPane.showMessageDialog(null, "CLIENTE REGISTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRO");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOproducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Cliente verificarCliente(String cedula) {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        Cliente cliente = new Cliente();
        try {
            String SQL = "SELECT * FROM cliente WHERE cedula=" + cedula;
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);
           if(rs.next()) {
               cliente.setNombre(rs.getString("nombre"));
               cliente.setCedula(rs.getString("cedula"));
               cliente.setGenero(rs.getString("genero"));
               cliente.setTelefono(rs.getString("telefono"));
           }
         return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
