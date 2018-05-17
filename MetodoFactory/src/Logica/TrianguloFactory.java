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
public class TrianguloFactory implements TrianguloMetodoFactory{

    @Override
    public Triangulo createTriangulo(int a, int b, int c) {
       if(a==b && b==c) return new Equilatero(a, b, c);
       if(a!=b && b!=c) return new Escaleno(a,b,c);
       return null;
       
       }
    }
    

