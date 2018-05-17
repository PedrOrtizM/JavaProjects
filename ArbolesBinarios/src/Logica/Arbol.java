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
public class Arbol {
    private Nodo raiz;

    public Arbol(){
        raiz = null;
    }
    
    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
   public boolean agregarNodo(int dato){
       
        Nodo nodo = new Nodo(null, null, dato);
        if(raiz == null){raiz=nodo;return true;}
     
        
        Nodo aux = raiz;
        Nodo auxPadre;
       
       for(;;){ 
           
           auxPadre = aux;
           
           if(dato<aux.getDato()){ 
               aux = aux.getHijoIzq();
               if(aux==null){ auxPadre.setHijoIzq(nodo); return true;}
           
           }
           
          else{ 
               aux = aux.getHijoDer();
               if(aux==null){ auxPadre.setHijoDer(nodo); return true;}
           
           }
    
           
       }
  
 
   }
   
   
   public void InOrden(Nodo raiz){
   //hijo izq,raiz, hijo derec 
    if(raiz!=null){
        InOrden(raiz.getHijoIzq());
        System.out.println(raiz.getDato());
        InOrden(raiz.getHijoDer());  
    }
   
   }
   
   public void preOrden(Nodo raiz){
       
    if(raiz!=null){
       
        System.out.println(raiz.getDato());
        preOrden(raiz.getHijoIzq());  
        preOrden(raiz.getHijoDer());
   }
   }
   
    public void postOrden(Nodo raiz){
      if(raiz!=null){
        
        postOrden(raiz.getHijoIzq());  
        postOrden(raiz.getHijoDer());
        System.out.println(raiz.getDato());
          
    
      }
    }
                            
   public boolean eliminar(int dato){                        
      Nodo aux = raiz;
      Nodo padre = raiz;
      boolean esHijoIzquierdo = true;

      while(aux.getDato() != dato)        // buscar el Nodo
         {
         padre = aux;
         if(dato < aux.getDato())         
            {
            esHijoIzquierdo = true;
            aux = aux.getHijoIzq();
            }
         else                            
            {
            esHijoIzquierdo = false;
            aux = aux.getHijoDer();
            }
         if(aux == null)            
            return false;             
         }  // fin del while
     
      
      if(aux.getHijoIzq() ==null && aux.getHijoDer()==null)
         {
         if(aux == raiz)             // Verificar si es la RAIZ,
            raiz = null;                 // Arbol vacio
         else if(esHijoIzquierdo)
            padre.setHijoIzq(null);     // se desconecta del padre
         else                            
            padre.setHijoDer(null);     // se desconecta del padre
         }

      // Si no tiene hijo derecho, remplazamos con el subarbol izquierdo
      else 
        if(aux.getHijoDer() == null)
                if(aux == raiz)
                    raiz = aux.getHijoIzq();
                else 
                    if(esHijoIzquierdo)                       
                        padre.setHijoIzq(aux.getHijoIzq());
                    else                        
                        padre.setHijoDer(aux.getHijoIzq());
        // si no tiene hijo izquierdo, reemplazamos con el subarbol derecho
        else 
          if(aux.getHijoIzq()==null)
                if(aux == raiz)
                    raiz = aux.getHijoDer();
                else 
                   if(esHijoIzquierdo)                     
                       padre.setHijoIzq(aux.getHijoDer());
                   else
                       //padre.rightChild = aux.rightChild;
                       padre.setHijoDer(aux.getHijoDer());
        else  // Si ambas condiciones son falsas, entonces tiene dos hijos
              //entonces reemplazamos con el sucesor mas pequeño del subarbol derecho
         {
         // Obtenemos el sucesor del nodo a borrar (aux)
         Nodo sucesor = getSucesor(aux);
         // conectamos el padre de aux con el sucesor 
         if(aux == raiz)
            raiz = sucesor;
         else 
             if(esHijoIzquierdo)
                padre.setHijoIzq(sucesor);
            else               
                padre.setHijoDer(sucesor);
         // conectamos sucesor al hijo izquierdo de aux 
         //sucesor.leftChild = aux.leftChild;
         sucesor.setHijoIzq(aux.getHijoIzq());
         
         }  // fin else dos hijos
      // (sucesor no puede tener hijo izquierdo)
      return true;                              
   }  // fin

 private Nodo getSucesor(Nodo delNodo)
      {
      Nodo sucesorpadre = delNodo;
      Nodo sucesor = delNodo;
      Nodo actual = delNodo.getHijoDer();   
      while(actual != null)               
         {                                 
         sucesorpadre = sucesor;
         sucesor = actual;
         actual = actual.getHijoIzq();     
         }
                                           
      if(sucesor != delNodo.getHijoDer())  
         {                                  
          sucesorpadre.setHijoIzq(sucesor.getHijoDer());
          sucesor.setHijoDer(delNodo.getHijoDer());
         }
      return sucesor;
      }
}