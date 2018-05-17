/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.Producto;
import java.sql.ResultSet;

/**
 *
 * @author Pedro Ortiz M
 */
public class DAOproducto {

    private Producto producto;
    public DAOproducto() {
      
    }

    public DAOproducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void registrar() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();

        String ComandoSQL = "INSERT INTO producto (nombre,descripcion,referencia,unidad,precioUnitario) "
                + "VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getReferencia());
            ps.setString(4, producto.getUnidad());
            ps.setDouble(5, producto.getPrecio());
            
            int aux =  ps.executeUpdate();
            
            if(aux>0)JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO");
            else   JOptionPane.showMessageDialog(null, "ERROR AL REGISTRO");

         
        } catch (SQLException ex) {
            Logger.getLogger(DAOproducto.class.getName()).log(Level.SEVERE, null, ex);
        }

           }
    
    
    
      public Producto verificarProducto(String referencia) {

        Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
        Statement st;
        Producto p = new Producto();
        
        try {
            String SQL = "SELECT * FROM producto WHERE referencia='" + referencia+"'";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(SQL);
           if(rs.next()) {
                     
               p.setNombre(rs.getString("nombre"));
               p.setPrecio(rs.getDouble("precioUnitario"));
               return p;
                       
           }
         
        } catch (SQLException ex) {
            Logger.getLogger(DAOproducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
      
      public void registrarInventario(){
      
         Conexion conexion = new Conexion();
        conexion.conectar();
        Connection con = conexion.getConexion();
 
        String ComandoSQL = "INSERT INTO inventario (referencia,cantidad) "
                + "VALUES(?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(ComandoSQL);
           
            ps.setString(1, producto.getReferencia());
            ps.setInt(2,0);
           
            
            int aux =  ps.executeUpdate();
            
            if(aux>0)System.out.println("REGISTRADO EN INVENTARIO");
            else  System.out.println("REGISTRADO EN INVENTARIO");
         
        } catch (SQLException ex) {
            Logger.getLogger(DAOproducto.class.getName()).log(Level.SEVERE, null, ex);
        }

      
      
      
      }

}
