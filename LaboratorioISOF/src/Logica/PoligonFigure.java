package Logica;


/**
 * @author Estudiante
 * @version 1.0
 * @created 19-Sept.-2016 10:21:54 p. m.
 */
public class PoligonFigure extends AttributedFigure {
    
    private double atributoPoli;

    public PoligonFigure(String forbiddenAttributes) {
        super(forbiddenAttributes);
    }

    public PoligonFigure(double atributoPoli, String forbiddenAttributes) {
        super(forbiddenAttributes);
        this.atributoPoli = atributoPoli;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPoligonFigure{" + "atributoPoligono = " + atributoPoli + '}';
    }

  

 


 



}//end PoligonFigure