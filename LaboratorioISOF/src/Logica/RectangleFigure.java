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
public class RectangleFigure extends AttributedFigure{
    private double rectangle;

    public RectangleFigure(double rectangle, String forbiddenAttributes) {
        super(forbiddenAttributes);
        this.rectangle = rectangle;
    }

    @Override
    public String toString() {
         return super.toString()+ ""
                 + "\nRectangleFigure{" + "Atributo rectangle = "  + rectangle + '}';
    }

    


}
