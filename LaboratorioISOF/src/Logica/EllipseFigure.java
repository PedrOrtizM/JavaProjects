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
public class EllipseFigure  extends AttributedFigure{
    
    private double ellipse;

    public EllipseFigure(double ellipse, String forbiddenAttributes) {
        super(forbiddenAttributes);
        this.ellipse = ellipse;
    }

    @Override
    public String toString() {
        return super.toString()+ 
                "\nEllipseFigure{" + "atributoEllipse = " + ellipse + '}';
    }
    


    
    
}
