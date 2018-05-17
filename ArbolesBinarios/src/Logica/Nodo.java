package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedro ortiz
 */
public class Nodo {
    private Nodo hijoDer;
    private Nodo hijoIzq;
    private int dato;

    public Nodo(Nodo hijoDer, Nodo hijoIzq, int dato) {
        this.hijoDer = hijoDer;
        this.hijoIzq = hijoIzq;
        this.dato = dato;
    }

    public Nodo() {
    }
    
    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
}
