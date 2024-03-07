import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
        raiz.esRojo = false;
    }

    Nodo insertarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRecursivo(raiz.derecha, valor);
        }
        return balancearRecursivo(raiz);
    }

    Nodo balancearRecursivo(Nodo nodo) {
        if (nodo.derecha != null && nodo.derecha.esRojo) {
            nodo = rotacionIzquierda(nodo);
        }

        if (nodo.izquierda != null && nodo.izquierda.esRojo && nodo.izquierda.izquierda != null
                && nodo.izquierda.izquierda.esRojo) {
            nodo = rotacionDerecha(nodo);
        }

        if (nodo.izquierda != null && nodo.izquierda.esRojo && nodo.derecha != null && nodo.derecha.esRojo) {
            cambiarColor(nodo);
        }

        return nodo;
    }

    Nodo rotacionIzquierda(Nodo nodo) {
        Nodo temp = nodo.derecha;
        nodo.derecha = temp.izquierda;
        temp.izquierda = nodo;
        temp.esRojo = nodo.esRojo;
        nodo.esRojo = true;
        return temp;
    }

    Nodo rotacionDerecha(Nodo nodo) {
        Nodo temp = nodo.izquierda;
        nodo.izquierda = temp.derecha;
        temp.derecha = nodo;
        temp.esRojo = nodo.esRojo;
        nodo.esRojo = true;
        return temp;
    }

    void cambiarColor(Nodo nodo) {
        nodo.esRojo = !nodo.esRojo;
        nodo.izquierda.esRojo = !nodo.izquierda.esRojo;
        nodo.derecha.esRojo = !nodo.derecha.esRojo;
    }

    void balancearArbol() {
        if (raiz != null) {
            raiz = balancearRecursivo(raiz);
            raiz.esRojo = false;
        }
    }

    void imprimirPorNiveles() {
        if (raiz == null)
            return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo temp = cola.poll();
            System.out.print(temp.valor + " ");

            if (temp.izquierda != null)
                cola.add(temp.izquierda);

            if (temp.derecha != null)
                cola.add(temp.derecha);
        }
    }
}