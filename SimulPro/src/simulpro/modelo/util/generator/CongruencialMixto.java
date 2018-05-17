/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.util.generator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariel Arnedo
 */
public abstract class CongruencialMixto {

    public static int[] createNumbers(int semilla,int adicion, int multiplicador, int modulo){
        List<Integer> list = new ArrayList<>();
        int newSemilla = semilla;
        while(true){
            list.add(newSemilla);
            newSemilla = (newSemilla * multiplicador + adicion) % modulo;
            if(list.get(0) == newSemilla)
                break;
            
            if(list.size() > modulo * 2)
                throw new RuntimeException("Periodo Infinito");
        }

        int a[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    } 
    
    public static java.util.List<Double> createListNumbersAleatory(int semilla,int adicion, int multiplicador, int modulo){
        java.util.List<Double> list = new java.util.ArrayList<>();
        int a[] = createNumbers(semilla, adicion, multiplicador, modulo);
        for (int i = 0; i < a.length; i++) {
            list.add((double)a[i]/(double)modulo);
        }
        return list;
    }
    
    public static double[] createNumbersAleatory(int semilla,int adicion, int multiplicador, int modulo){
        
        int a[] = createNumbers(semilla, adicion, multiplicador, modulo);
        double [] x = new double[a.length];
        
        for (int i = 0; i < a.length; i++) {
            x[i] = (double)a[i]/(double)modulo;
        }
        return x;
    } 
}
