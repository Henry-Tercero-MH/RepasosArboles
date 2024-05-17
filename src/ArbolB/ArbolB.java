package ArbolB;

import java.util.ArrayList;


// Clase para representar un nodo en el Árbol B
class NodoB {
    int t; // Grado mínimo
    ArrayList<EmpleadoB> claves;
    ArrayList<NodoB> hijos;
    boolean hoja;

    public NodoB(int t, boolean hoja) {
        this.t = t;
        this.hoja = hoja;
        this.claves = new ArrayList<>();
        this.hijos = new ArrayList<>();
    }

    // Insertar una nueva clave en un nodo no lleno
    public void insertarNoLleno(EmpleadoB k) {
        int i = claves.size() - 1;

        if (hoja) {
            while (i >= 0 && claves.get(i).id > k.id) {
                i--;
            }
            claves.add(i + 1, k);
        } else {
            while (i >= 0 && claves.get(i).id > k.id) {
                i--;
            }
            if (hijos.get(i + 1).claves.size() == 2 * t - 1) {
                dividirHijo(i + 1, hijos.get(i + 1));
                if (claves.get(i + 1).id < k.id) {
                    i++;
                }
            }
            hijos.get(i + 1).insertarNoLleno(k);
        }
    }

    // Dividir un hijo y
    public void dividirHijo(int i, NodoB y) {
        NodoB z = new NodoB(y.t, y.hoja);
        for (int j = 0; j < t - 1; j++) {
            z.claves.add(y.claves.remove(t));
        }
        if (!y.hoja) {
            for (int j = 0; j < t; j++) {
                z.hijos.add(y.hijos.remove(t));
            }
        }
        hijos.add(i + 1, z);
        claves.add(i, y.claves.remove(t - 1));
    }

    // Método para realizar un recorrido inorden
    public void recorridoInorden() {
        int i;
        for (i = 0; i < claves.size(); i++) {
            if (!hoja) {
                hijos.get(i).recorridoInorden();
            }
            System.out.println(claves.get(i));
        }
        if (!hoja) {
            hijos.get(i).recorridoInorden();
        }
    }

    // Método para buscar una clave en el subárbol enraizado con este nodo
    public EmpleadoB buscar(int id) {
        int i = 0;
        while (i < claves.size() && id > claves.get(i).id) {
            i++;
        }

        if (i < claves.size() && claves.get(i).id == id) {
            return claves.get(i);
        }

        if (hoja) {
            return null;
        }

        return hijos.get(i).buscar(id);
    }
}

// Clase para implementar el Árbol B
public class ArbolB {
    NodoB raiz;
    int t;

    public ArbolB(int t) {
        this.raiz = null;
        this.t = t;
    }

    public void insertar(EmpleadoB k) {
        if (raiz == null) {
            raiz = new NodoB(t, true);
            raiz.claves.add(k);
        } else {
            if (raiz.claves.size() == 2 * t - 1) {
                NodoB s = new NodoB(t, false);
                s.hijos.add(raiz);
                s.dividirHijo(0, raiz);

                int i = 0;
                if (s.claves.get(0).id < k.id) {
                    i++;
                }
                s.hijos.get(i).insertarNoLleno(k);

                raiz = s;
            } else {
                raiz.insertarNoLleno(k);
            }
        }
    }

    public EmpleadoB buscar(int id) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(id);
        }
    }

    public void recorridoInorden() {
        if (raiz != null) {
            raiz.recorridoInorden();
        }
    }
}



