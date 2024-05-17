package ArbolesAVL;

// Clase para representar a un empleado
public class Empleado {
    int id;
    String nombre;
    String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto;
    }
}

// Clase para representar un nodo en el árbol AVL
class NodoAVL {
    Empleado empleado;
    NodoAVL izquierda, derecha;
    int altura;

    public NodoAVL(Empleado empleado) {
        this.empleado = empleado;
        this.izquierda = this.derecha = null;
        this.altura = 1;
    }
}



