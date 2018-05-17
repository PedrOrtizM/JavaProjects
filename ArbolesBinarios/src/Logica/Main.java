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
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   {
        Arbol nuevo = new Arbol();
//        ArrayList<Integer> lista = new ArrayList<>();
//        int num;
//       
//        num = Integer.parseInt(JOptionPane.showInputDialog("NUMERO DE NODOS: "));
//       
//        for(int i=0;i<num;i++){
//       
//        lista.add( Integer.parseInt(JOptionPane.showInputDialog("NODO: ")));
//        
//        }
//        
//        nuevo.agregarNodo(lista.get(lista.size()-1));
//        
//        for(int i=0;i<lista.size()-1;i++){
//            
//           nuevo.agregarNodo(lista.get(i));
//        
//        }


    
//
        nuevo.agregarNodo(8);
        nuevo.agregarNodo(3);
        nuevo.agregarNodo(10);
        nuevo.agregarNodo(14);
        nuevo.agregarNodo(13);
        nuevo.agregarNodo(1);
        nuevo.agregarNodo(6);
        nuevo.agregarNodo(4);
        nuevo.agregarNodo(7);

       nuevo.postOrden(nuevo.getRaiz());
//
       System.out.println("RAIZ " + nuevo.getRaiz().getDato());

    }

}
