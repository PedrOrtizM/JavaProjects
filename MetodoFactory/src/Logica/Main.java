/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Pedro Ortiz M
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TrianguloMetodoFactory factory = new TrianguloFactory();
       Triangulo triangulo = factory.createTriangulo(1, 2, 3);
        System.out.println(triangulo.getDescripcion());
    }
    
}
