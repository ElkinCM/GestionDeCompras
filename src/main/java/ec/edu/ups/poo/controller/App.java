package ec.edu.ups.poo.controller;
import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.producto.ProductoFisico;
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
                        for  (int j=0; j<cantidadProductos; j++){
                            System.out.print("Ingrese el id del producto: ");
                            int id = leer.nextInt();
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombreProducto = leer.next();
                            System.out.print("Ingrese el precio unitario del producto: ");
                            int precioUnitario = leer.nextInt();
                            System.out.print("Ingrese la cantidad del producto: ");
                            int cantidadProducto = leer.nextInt();
                            System.out.print("Ingrese la descripcion del producto: ");
                            String descripcion = leer.next();
                            System.out.print("Ingrese la presentacion del producto: ");
                            String presentacion = leer.next();
                            ProductoFisico  nuevoProducto = new ProductoFisico(id, nombreProducto, precioUnitario, cantidadProducto, descripcion, presentacion); 
                            nuevoProveedor.getProductos().add(nuevoProducto);
                        }


                        proveedores.add(nuevoProveedor);
                    }
                    System.out.println("Proveedores registrados exitosamente.");
                    
                    break;
                case 2:
                    System.out.println("**Mostrar Proveedores**");
                    if (proveedores.isEmpty()) {
                        System.out.println("No hay proveedores registrados.");
                    } else {
                        // Recorremos la lista de proveedores con un ciclo for tradicional
                        for (int i = 0; i < proveedores.size(); i++) {
                            Proveedor proveedorShow = proveedores.get(i);  // Accedemos al proveedor usando su índice
                            System.out.println("Proveedor #" + (i + 1));
                            System.out.println("Nombre: " + proveedorShow.getNombre());  // Imprimimos el nombre del proveedor
                            System.out.println("Cédula: " + proveedorShow.getCedula());  // Imprimimos la cédula del proveedor
                            System.out.println("Empresa: " + proveedorShow.getEmpresa());  // Imprimimos la empresa del proveedor
                            System.out.println("RUC: " + proveedorShow.getRuc());  // Imprimimos el RUC del proveedor
                
                            // Verificamos si el proveedor tiene productos
                            if (proveedor.getProductos().isEmpty()) {
                                System.out.println("  No tiene productos registrados.");
                            } else {
                                System.out.println("  Productos registrados:");
                                // Recorremos los productos del proveedor
                                for (int j = 0; j < proveedor.getProductos().size(); j++) {
                                    ProductoFisico producto = (ProductoFisico) proveedorShow.getProductos().get(j);  // Hacemos un cast porque sabemos que es ProductoFisico
                                    System.out.println("    Producto ID: " + producto.getId());
                                    System.out.println("    Nombre: " + producto.getNombre());
                                    System.out.println("    Precio Unitario: " + producto.getPrecioUnitario());
                                    System.out.println("    Cantidad: " + producto.getCantidad());
                                    System.out.println("    Descripción: " + producto.getDescripcion());
                                    System.out.println("    Presentación: " + producto.getPresentacion());
                                    System.out.println("    --------------------------");
                                }
                            }
                            System.out.println("-------------------------------------------------");
                        }
                    }
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