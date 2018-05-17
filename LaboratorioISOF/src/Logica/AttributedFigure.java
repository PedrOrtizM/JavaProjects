/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author USUARIO
 */
public class AttributedFigure {

    protected String atributoFigura;

    public AttributedFigure(String atributoFigura) {
        this.atributoFigura = atributoFigura;
    }

    @Override
    public String toString() {
        return "AttributedFigure{" + "atributoFigura = " + atributoFigura + '}';
    }

    public String getAtributoFigura() {
        return atributoFigura;
    }

    public void setAtributoFigura(String atributoFigura) {
        this.atributoFigura = atributoFigura;
    }

   


}
