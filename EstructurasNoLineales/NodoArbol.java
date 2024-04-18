package EstructurasNoLineales;

public class NodoArbol {

     private int dato;
     private NodoArbol izquierdo;
     private NodoArbol derecho;

     public NodoArbol(int dato){
         this.dato = dato;
         this.izquierdo = null;
         this.derecho = null;
     }

     public NodoArbol getIzquierdo() {
          return izquierdo;
     }

     public NodoArbol getDerecho() {
          return derecho;
     }

     public int getDato() {
          return dato;
     }

     public void insertar(int valor){
          if (valor < this.dato){
               if (izquierdo == null){
                    izquierdo = new NodoArbol(valor);
               }else{
                    izquierdo.insertar(valor);
               }
          }else{
               if (derecho == null){
                    derecho = new NodoArbol(valor);
               }else{
                    derecho.insertar(valor);
               }
          }
     }


}
