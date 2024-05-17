package ArbolesBinarios;

// Clase para representar a un empleado
public class EmpleadoBinario {
    int id;
    String nombre;
    String puesto;

    public EmpleadoBinario(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto;
    }
}
