package Logica;

/**
 * @author Pedro Ortiz M
 * @version 1.0
 * @created 20-nov.-2017 5:43:27 p. m.
 */
public class Proveedor {

    private String razon_social;
    private String direccion;
    private String telefono;
    private String email;

    public Proveedor() {

    }

    public Proveedor(String razon_social, String direccion, String telefono, String email) {
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}//end Proveedor
