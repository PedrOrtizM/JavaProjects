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
public class FabricaFigura {

    public FabricaFigura() {
    }
    
    
    
	public AttributedFigure getAttributed(int numFigura, String atributo, double numero){
            AttributedFigure nueva=null;
            
            switch (numFigura) {
            case 1:
                nueva = new EllipseFigure(numero,atributo);
                break;

            case 2:
                nueva = new PoligonFigure(numero, atributo);
                break;

            case 3:
                nueva = new RectangleFigure(numero, atributo);
                break;
            default: System.out.println("ID invalido");

        }
        return nueva;
       
	}
        
        
}
