public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        int[] valores = { 5, 3, 7, 2, 4, 6, 8 };

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        System.out.println("Árbol antes de balancear:");
        arbol.imprimirPorNiveles();
        arbol.balancearArbol();

        System.out.println("\n\nÁrbol después de balancear:");
        arbol.imprimirPorNiveles();
    }
}