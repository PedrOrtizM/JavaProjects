/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pedro Ortiz M
 */
public class Conexion {

    private Connection conexion;

    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/mydb";

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean conectar() {
        conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,user,password);
            if(conexion!=null){
            
                System.out.println("Conectado a la BD");
                return true;
            }
            
        } catch (Exception e) { 
            System.out.println("ERROR al conectar "+e);
            return false;
        }

       return false;
    }

}
