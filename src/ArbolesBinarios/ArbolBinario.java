package ArbolesBinarios;

import java.util.Scanner;

// Clase para representar un nodo en el Árbol Binario
class NodoBinario {
    EmpleadoBinario empleado;
    NodoBinario izquierdo, derecho;

    public NodoBinario(EmpleadoBinario empleado) {
        this.empleado = empleado;
        this.izquierdo = this.derecho = null;
    }
}

// Clase para implementar el Árbol Binario
public class ArbolBinario {
    NodoBinario raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(EmpleadoBinario empleado) {
        raiz = insertarRec(raiz, empleado);
    }

    private NodoBinario insertarRec(NodoBinario raiz, EmpleadoBinario empleado) {
        if (raiz == null) {
            raiz = new NodoBinario(empleado);
            return raiz;
        }

        if (empleado.id < raiz.empleado.id) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, empleado);
        } else if (empleado.id > raiz.empleado.id) {
            raiz.derecho = insertarRec(raiz.derecho, empleado);
        }
        return raiz;
    }

    public EmpleadoBinario buscar(int id) {
        return buscarRec(raiz, id);
    }

    private EmpleadoBinario buscarRec(NodoBinario raiz, int id) {
        if (raiz == null || raiz.empleado.id == id) {
            return raiz != null ? raiz.empleado : null;
        }

        if (id < raiz.empleado.id) {
            return buscarRec(raiz.izquierdo, id);
        }

        return buscarRec(raiz.derecho, id);
    }

    public void recorridoInorden() {
        recorridoInordenRec(raiz);
    }

    private void recorridoInordenRec(NodoBinario raiz) {
        if (raiz != null) {
            recorridoInordenRec(raiz.izquierdo);
            System.out.println(raiz.empleado);
            recorridoInordenRec(raiz.derecho);
        }
    }

    public void recorridoPreorden() {
        recorridoPreordenRec(raiz);
    }

    private void recorridoPreordenRec(NodoBinario raiz) {
        if (raiz != null) {
            System.out.println(raiz.empleado);
            recorridoPreordenRec(raiz.izquierdo);
            recorridoPreordenRec(raiz.derecho);
        }
    }

    public void recorridoPostorden() {
        recorridoPostordenRec(raiz);
    }

    private void recorridoPostordenRec(NodoBinario raiz) {
        if (raiz != null) {
            recorridoPostordenRec(raiz.izquierdo);
            recorridoPostordenRec(raiz.derecho);
            System.out.println(raiz.empleado);
        }
    }
}


