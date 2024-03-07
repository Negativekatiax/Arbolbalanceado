class Nodo {
    int valor;
    Nodo izquierda, derecha;
    boolean esRojo;

    public Nodo(int item) {
        valor = item;
        izquierda = derecha = null;
        esRojo = true;
    }
}
