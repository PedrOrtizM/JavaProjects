package Logica;


public class Main {


    public static void main(String[] args) {
        
        
        AttributedFigure a;
        FabricaFigura fabrica;
        
        fabrica = new FabricaFigura();
        a = fabrica.getAttributed(3, "SoyFigura", 123123);
        System.out.println(a);
    }
    
}
