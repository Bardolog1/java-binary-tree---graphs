package EstructurasNoLineales;

public class Arbol {

    NodoArbol initArbol;

    public Arbol(){
        this.initArbol = null;
    }

    public void insertar(int valor){
        if(initArbol == null){
            initArbol = new NodoArbol(valor);
        } else {
            initArbol.insertar(valor);
        }
    }



    public void dispPreorden(){
        this.preorden(initArbol);
    }

    public void preorden(NodoArbol arbol){
        if(arbol == null){
            return;
        }
        System.out.print(arbol.getDato()+" - ");
        preorden(arbol.getIzquierdo());
        preorden(arbol.getDerecho());
    }

    public void dispInrden(){
        this.inorden(initArbol);
    }

    public void inorden(NodoArbol arbol){
        if(arbol == null){
            return;
        }
        inorden(arbol.getIzquierdo());
        System.out.print(arbol.getDato()+" - ");
        inorden(arbol.getDerecho());
    }



    public void dispposorden(){
        this.posorden(initArbol);
    }

    public void posorden(NodoArbol arbol){
        if(arbol == null){
            return;
        }
        posorden(arbol.getIzquierdo());
        posorden(arbol.getDerecho());
        System.out.print(arbol.getDato()+" - ");
    }

}
