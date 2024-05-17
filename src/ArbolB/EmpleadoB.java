package ArbolB;

// Clase para representar a un empleado
public class EmpleadoB {
    int id;
    String nombre;
    String puesto;

    public EmpleadoB(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto;
    }
}
