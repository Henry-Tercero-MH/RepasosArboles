import ArbolesBinarios.*;
import ArbolesAVL.*;
import ArbolB.*;


import java.util.Scanner;
        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Árboles binarios");
                    System.out.println("2. Árboles AVL");
                    System.out.println("3. Árbol B");
                    System.out.println("4. Salir");

                    int opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                                    ArbolBinario arbolBinario = new ArbolBinario();

                                    while (true) {
                                        System.out.println("\nMenú:");
                                        System.out.println("1. Insertar empleado");
                                        System.out.println("2. Buscar empleado");
                                        System.out.println("3. Recorrido Inorden");
                                        System.out.println("4. Recorrido Preorden");
                                        System.out.println("5. Recorrido Postorden");
                                        System.out.println("6. Salir");
                                        System.out.print("Elija una opción: ");

                                        opcion = scanner.nextInt();
                                        scanner.nextLine(); // Consumir el salto de línea

                                        switch (opcion) {
                                            case 1:
                                                System.out.print("Ingrese el ID del empleado: ");
                                                int id = scanner.nextInt();
                                                scanner.nextLine(); // Consumir el salto de línea
                                                System.out.print("Ingrese el nombre del empleado: ");
                                                String nombre = scanner.nextLine();
                                                System.out.print("Ingrese el puesto del empleado: ");
                                                String puesto = scanner.nextLine();
                                                EmpleadoBinario nuevoEmpleado = new EmpleadoBinario(id, nombre, puesto);
                                                arbolBinario.insertar(nuevoEmpleado);
                                                System.out.println("Empleado insertado correctamente.");
                                                break;
                                           case 2:
                                                System.out.print("Ingrese el ID del empleado a buscar: ");
                                                int idBuscar = scanner.nextInt();
                                                EmpleadoBinario empleadoEncontrado = arbolBinario.buscar(idBuscar);
                                                if (empleadoEncontrado != null) {
                                                    System.out.println("Empleado encontrado: " + empleadoEncontrado);
                                                } else {
                                                    System.out.println("Empleado no encontrado.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Recorrido Inorden:");
                                                arbolBinario.recorridoInorden();
                                                break;
                                            case 4:
                                                System.out.println("Recorrido Preorden:");
                                                arbolBinario.recorridoPreorden();
                                                break;
                                            case 5:
                                                System.out.println("Recorrido Postorden:");
                                                arbolBinario.recorridoPostorden();
                                                break;
                                            case 6:
                                                System.out.println("Saliendo del sistema.");
                                                scanner.close();
                                                System.exit(0);
                                                break;
                                            default:
                                                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                                break;
                                        }
                                    }


                        case 2:
                            //  árboles AVL
                                    ArbolAVL arbolAVL = new ArbolAVL();

                                    while (true) {
                                        System.out.println("\nMenú:");
                                        System.out.println("1. Insertar empleado");
                                        System.out.println("2. Buscar empleado");
                                        System.out.println("3. Recorrido Inorden");
                                        System.out.println("4. Recorrido Preorden");
                                        System.out.println("5. Recorrido Postorden");
                                        System.out.println("6. Salir");
                                        System.out.print("Elija una opción: ");

                                        opcion = scanner.nextInt();
                                        scanner.nextLine(); // Consumir el salto de línea

                                        switch (opcion) {
                                            case 1:
                                                System.out.print("Ingrese el ID del empleado: ");
                                                int id = scanner.nextInt();
                                                scanner.nextLine(); // Consumir el salto de línea
                                                System.out.print("Ingrese el nombre del empleado: ");
                                                String nombre = scanner.nextLine();
                                                System.out.print("Ingrese el puesto del empleado: ");
                                                String puesto = scanner.nextLine();
                                                Empleado nuevoEmpleado = new Empleado(id, nombre, puesto);
                                                arbolAVL.raiz = arbolAVL.insertar(arbolAVL.raiz, nuevoEmpleado);
                                                System.out.println("Empleado insertado correctamente.");
                                                break;
                                            case 2:
                                                System.out.print("Ingrese el ID del empleado a buscar: ");
                                                int idBuscar = scanner.nextInt();
                                                Empleado empleadoEncontrado = arbolAVL.obtenerEmpleado(arbolAVL.raiz, idBuscar);
                                                if (empleadoEncontrado != null) {
                                                    System.out.println("Empleado encontrado: " + empleadoEncontrado);
                                                } else {
                                                    System.out.println("Empleado no encontrado.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Recorrido Inorden:");
                                                arbolAVL.recorridoInorden(arbolAVL.raiz);
                                                break;
                                            case 4:
                                                System.out.println("Recorrido Preorden:");
                                                arbolAVL.recorridoPreorden(arbolAVL.raiz);
                                                break;
                                            case 5:
                                                System.out.println("Recorrido Postorden:");
                                                arbolAVL.recorridoPostorden(arbolAVL.raiz);
                                                break;
                                            case 6:
                                                System.out.println("Saliendo del sistema.");
                                                scanner.close();
                                                System.exit(0);
                                                break;
                                            default:
                                                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                                break;
                                        }
                                    }



                        case 3:
                            // Lógica para árbol B
                            // Clase para implementar el sistema de gestión de empleados

                                    System.out.print("Ingrese el grado mínimo del Árbol B: ");
                                    int grado = scanner.nextInt();
                                    ArbolB arbolB = new ArbolB(grado);

                                    while (true) {
                                        System.out.println("\nMenú:");
                                        System.out.println("1. Insertar empleado");
                                        System.out.println("2. Buscar empleado");
                                        System.out.println("3. Recorrido Inorden");
                                        System.out.println("4. Salir");
                                        System.out.print("Elija una opción: ");

                                        opcion = scanner.nextInt();
                                        scanner.nextLine(); // Consumir el salto de línea

                                        switch (opcion) {
                                            case 1:
                                                System.out.print("Ingrese el ID del empleado: ");
                                                int id = scanner.nextInt();
                                                scanner.nextLine(); // Consumir el salto de línea
                                                System.out.print("Ingrese el nombre del empleado: ");
                                                String nombre = scanner.nextLine();
                                                System.out.print("Ingrese el puesto del empleado: ");
                                                String puesto = scanner.nextLine();
                                                EmpleadoB nuevoEmpleadoB = new EmpleadoB(id, nombre, puesto);
                                                arbolB.insertar(nuevoEmpleadoB);
                                                System.out.println("Empleado insertado correctamente.");
                                                break;
                                            case 2:
                                                System.out.print("Ingrese el ID del empleado a buscar: ");
                                                int idBuscar = scanner.nextInt();
                                                EmpleadoB empleadoEncontradoB = arbolB.buscar(idBuscar);
                                                if (empleadoEncontradoB != null) {
                                                    System.out.println("Empleado encontrado: " + empleadoEncontradoB);
                                                } else {
                                                    System.out.println("Empleado no encontrado.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Recorrido Inorden:");
                                                arbolB.recorridoInorden();
                                                break;
                                            case 4:
                                                System.out.println("Saliendo del sistema.");
                                                scanner.close();
                                                System.exit(0);
                                                break;
                                            default:
                                                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                                break;
                                        }
                                    }


                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Opción no válida");
                    }
                }
            }


    }
