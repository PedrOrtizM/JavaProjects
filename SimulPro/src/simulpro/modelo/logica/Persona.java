/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

import java.awt.Point;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ariel Arnedo
 */
public class Persona implements Cloneable{
    
    private Point coordBox;

    private String genero;
    private String tipo;
    
    
    private String shape;
    private long timeDeLLegada; //
    private long timeDeServicio; //
    private int timeEntreLlegada;
    private int timeCaja;
    private int timeAtencion;
    private List<String> productosComprados;

    public Persona() {
        coordBox = new Point(1364,50);
    }

    public Persona(String genero) {
        this();
        this.genero = genero;
    }
            
    public Persona(String genero, String tipo) {
        this(genero);
        this.tipo = tipo;
    }

    public Persona(int timeCaja, int timeAtencion) {
        this();
        this.timeCaja = timeCaja;
        this.timeAtencion = timeAtencion;
    }

    public Persona(int timeEntreLlegada, int timeCaja, int timeAtencion) {
        this(timeCaja,timeAtencion);
        this.timeEntreLlegada = timeEntreLlegada;
    }
       
    public Persona(String genero, String tipo, int timeCaja, int timeAtencion) {
        this.genero = genero;
        this.tipo = tipo;
        this.timeCaja = timeCaja;
        this.timeAtencion = timeAtencion;
    }

    public Persona(String genero, String tipo, int timeCaja, int timeAtencion, List<String> productosComprados) {
        this.genero = genero;
        this.tipo = tipo;
        this.timeCaja = timeCaja;
        this.timeAtencion = timeAtencion;
        this.productosComprados = productosComprados;
    }

    public Persona(String genero, String tipo, String shape, long timeDeLLegada, long timeDeServicio, int timeEntreLlegada) {
        this.genero = genero;
        this.tipo = tipo;
        this.shape = shape;
        this.timeDeLLegada = timeDeLLegada;
        this.timeDeServicio = timeDeServicio;
        this.timeEntreLlegada = timeEntreLlegada;
    }

    public Persona(String genero, String tipo, String shape, long timeDeLLegada, long timeDeServicio, int timeEntreLlegada, List<String> productosComprados) {
        this.genero = genero;
        this.tipo = tipo;
        this.shape = shape;
        this.timeDeLLegada = timeDeLLegada;
        this.timeDeServicio = timeDeServicio;
        this.timeEntreLlegada = timeEntreLlegada;
        this.productosComprados = productosComprados;
    }
    
    public void moveInBox(){
       if(coordBox.x - 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed()<= 250){
           coordBox.move(250, 50);
       }else 
            coordBox.move((int)(coordBox.x - 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed()), 50);
    }
    
    public void moveInAttention(){
        if(coordBox.y + 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed() > 500){
            coordBox.move(250,500);
        }else
            coordBox.move(250, (int)(coordBox.y + 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed()));
    }
    
    public void moveExit(){
        if(coordBox.x + 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed() > 2000){
            coordBox.move(2000,0);
        }else
            coordBox.move((int)(coordBox.x + 5 / ControlModel.getControlModel().getAnimation().getAnimationSpeed()), coordBox.y);
    }
    
    public int getX(){
        return coordBox.x;
    }
    
    public int getY(){
        return coordBox.y;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public long getTimeDeLLegada() {
        return timeDeLLegada;
    }

    public long getTimeDeServicio() {
        return timeDeServicio;
    }
    
    public Persona timeServicio(long time){
        this.timeDeServicio = time;
        return this;
    }
    
    public Persona timeLLegada(long time){
        this.timeDeLLegada = time;
        return this;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getTimeCaja() {
        return timeCaja * 1000L;
    }

    public void setTimeCaja(int timeCaja) {
        this.timeCaja = timeCaja;
    }

    public long getTimeAtencion() {
        return timeAtencion * 1000L;
    }

    public void setTimeAtencion(int timeAtencion) {
        this.timeAtencion = timeAtencion;
    }

    public List<String> getProductosComprados() {
        return productosComprados;
    }

    public long getTimeEntreLlegada() {
        return timeEntreLlegada * 1000L;
    }

    public void setTimeEntreLlegada(int timeEntreLlegada) {
        this.timeEntreLlegada = timeEntreLlegada;
    }
    
    public void setProductosComprados(List<String> productosComprados) {
        this.productosComprados = productosComprados;
    }

    @Override
    public String toString() {
        return "Persona{" + "genero: " + genero + "\tTipo: " + tipo + "\ttimeEntreLlegada: " + timeEntreLlegada + "\ttimeCaja: " + timeCaja + "\ttimeAtencion: " + timeAtencion + "\tproductosComprados: " + productosComprados + '}';
    }

    public String getCategoriasCompradas(){
        if(productosComprados == null){
            return "No Compré Nada";
        }
        if(productosComprados.size() == 1){
            return productosComprados.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < productosComprados.size() ; i++) {
            sb.append(productosComprados.get(i));
            if(i== 0){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    @Override
    protected Object clone()  {
        try {
            return super.clone(); //To change body of generated methods, choose Tools | Templates.
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
