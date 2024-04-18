package EstructurasNoLineales;

public class main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(43);
        arbol.insertar(10);
        arbol.insertar(8);
        arbol.insertar(54);
        arbol.insertar(15);
        arbol.insertar(50);
        arbol.insertar(53);
        arbol.insertar(25);
        arbol.insertar(1);
        arbol.insertar(60);
        arbol.insertar(105);
        arbol.insertar(6);
        arbol.insertar(11);
        arbol.insertar(42);
        arbol.insertar(21);

        System.out.println("Preorden: ");
        arbol.dispPreorden();
        System.out.println("");
        System.out.println("Inorden: ");
        arbol.dispInrden();
        System.out.println("");
        System.out.println("Posorden: ");
        arbol.dispposorden();
        System.out.println("");



    }
}
