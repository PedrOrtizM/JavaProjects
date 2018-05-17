
package Logica;

public class Tiempo {
    
    private short horas;
    private short minutos;
    private short segundos;
    private short milisegundos;

    public short getMilisegundos() {
        return milisegundos;
    }

    public void setMilisegundos(short milisegundos) {
        this.milisegundos = milisegundos;
    }

    public Tiempo(short horas, short minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    public Tiempo(short horas, short minutos, short segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Tiempo() {
        this.horas=0;
        this.milisegundos=0;
        this.segundos=0;
        this.minutos=0;
    }

    
    public short getHoras() {
        return horas;
    }

    public void setHoras(short horas) {
        this.horas = horas;
    }

    public short getMinutos() {
        return minutos;
    }

    public void setMinutos(short minutos) {
        this.minutos = minutos;
    }

    public short getSegundos() {
        return segundos;
    }

    public void setSegundos(short segundos) {
        this.segundos = segundos;
    }
    
    
}
