package ArbolesAVL;

// Clase para implementar el árbol AVL
public class ArbolAVL {
    public NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    int altura(NodoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    int getBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierda) - altura(N.derecha);
    }

    public NodoAVL insertar(NodoAVL nodo, Empleado empleado) {
        if (nodo == null)
            return (new NodoAVL(empleado));

        if (empleado.id < nodo.empleado.id)
            nodo.izquierda = insertar(nodo.izquierda, empleado);
        else if (empleado.id > nodo.empleado.id)
            nodo.derecha = insertar(nodo.derecha, empleado);
        else
            return nodo;

        nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));

        int balance = getBalance(nodo);

        if (balance > 1 && empleado.id < nodo.izquierda.empleado.id)
            return rotacionDerecha(nodo);

        if (balance < -1 && empleado.id > nodo.derecha.empleado.id)
            return rotacionIzquierda(nodo);

        if (balance > 1 && empleado.id > nodo.izquierda.empleado.id) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && empleado.id < nodo.derecha.empleado.id) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    boolean buscar(NodoAVL nodo, int id) {
        if (nodo == null) {
            return false;
        }

        if (nodo.empleado.id == id) {
            return true;
        }

        return id < nodo.empleado.id ? buscar(nodo.izquierda, id) : buscar(nodo.derecha, id);
    }

    public Empleado obtenerEmpleado(NodoAVL nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (nodo.empleado.id == id) {
            return nodo.empleado;
        }

        return id < nodo.empleado.id ? obtenerEmpleado(nodo.izquierda, id) : obtenerEmpleado(nodo.derecha, id);
    }

    public void recorridoInorden(NodoAVL nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierda);
            System.out.println(nodo.empleado);
            recorridoInorden(nodo.derecha);
        }
    }

    public void recorridoPreorden(NodoAVL nodo) {
        if (nodo != null) {
            System.out.println(nodo.empleado);
            recorridoPreorden(nodo.izquierda);
            recorridoPreorden(nodo.derecha);
        }
    }

    public void recorridoPostorden(NodoAVL nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izquierda);
            recorridoPostorden(nodo.derecha);
            System.out.println(nodo.empleado);
        }
    }
}
