package ec.edu.ups.poo.controller;
import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner leer = new Scanner(System.in);
        Proveedor proveedor = new Proveedor();
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        do {
            
            System.out.println("Menu del programa");
            System.out.println("1. Registrar Proveedores");
            System.out.println("2. Agregar Proveedor");
            System.out.println("3. Buscar Proveedor");
            System.out.println("4. Registrar Solicitud de Compra");
            System.out.println("5. Buscar Solicitud de Compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            option = leer.nextInt();
            switch (option) {
                case 1:
                    System.out.println("**Registrar Proveedores**");

                    System.out.print("Ingrese cuantos proveedores desea registrar: ");
                    int cantidad = leer.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Ingrese la cédula del proveedor: ");
                        String cedula = leer.next();
                        System.out.print("Ingrese el nombre del proveedor: ");
                        String nombre = leer.next();
                        System.out.print("Ingrese el RUC del proveedor: ");
                        String ruc = leer.next();
                        System.out.print("Ingrese el nombre de la empresa: ");
                        String empresa = leer.next();
                        
                        Proveedor nuevoProveedor = new Proveedor(cedula, nombre, ruc, empresa);

                        System.out.println("Cuantos productos desea registrar para este proveedor? ");
                        int cantidadProductos = leer.nextInt();
                        for (int j = 0; j < cantidadProductos; j++) {
                            System.out.print("Ingrese el ID del producto: ");
                            int id = leer.nextInt();
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombreProducto = leer.next();
                            System.out.print("Ingrese el precio unitario del producto: ");
                            int precioUnitario = leer.nextInt();
                            System.out.print("Ingrese la cantidad del producto: ");
                            int cantidadProducto = leer.nextInt();
                            //Producto producto = new Producto(id, nombreProducto, precioUnitario, cantidad);
                            
                
                        }


                        proveedores.add(nuevoProveedor);
                    }
                    System.out.println("Proveedores registrados exitosamente.");
                    
                    break;
                case 2:
                    System.out.println("**Mostrar Proveedores**");
                    
                    break;
                case 3:
                    System.out.println("**Buscar Proveedor**");
                    System.out.print("1. Buscar por nombre\n2. Buscar por cedula\nSeleccione una opción: ");
                    int searchOption = leer.nextInt();
                    if (searchOption == 1) {
                        System.out.print("Ingrese el nombre del proveedor: ");
                        String nombre = leer.next();
                        proveedor.sortByNameInsertion(null);
                        proveedor.searchByName(null, nombre);

                    } else if (searchOption == 2) {
                        System.out.print("Ingrese la cédula del proveedor: ");
                        String cedula = leer.next();
                        proveedor.sortByCedulaInsertion(null); 
                        proveedor.searchByCedula(null, cedula);
                   
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                    
                    break;
                case 4:
                    System.out.println("**Registrar Solicitud de Compra**");
                    
                    break;
                case 5:
                    System.out.println("**Buscar Solicitud de Compra**");
                    
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            
            } while (option != 6);
    }   
}