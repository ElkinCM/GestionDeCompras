package ec.edu.ups.poo.controller;

import ec.edu.ups.poo.models.producto.ProductoFisico;
import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.Proveedor;
import ec.edu.ups.poo.models.DetalleCompra;
import ec.edu.ups.poo.models.SolicitudCompra;
import ec.edu.ups.poo.models.enums.DepartamentoEnum;
import ec.edu.ups.poo.models.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int option = 0;
        try (Scanner leer = new Scanner(System.in)) {
            ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
        int solicitudIdCounter = 1; // Contador para generar IDs automáticos de solicitudes

        do {
            System.out.println("\n========= MENÚ DEL PROGRAMA =========");
            System.out.println("1. Registrar Proveedor");
            System.out.println("2. Mostrar Proveedores");
            System.out.println("3. Buscar Proveedor y Agregar Producto");
            System.out.println("4. Registrar Solicitud de Compra");
            System.out.println("5. Buscar Solicitud de Compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!leer.hasNextInt()) {
                System.out.println("Error: debe ingresar un número.");
                leer.next();
            }
            option = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.println("\n** REGISTRAR PROVEEDOR **");
                    System.out.print("Ingrese la cédula del proveedor: ");
                    String cedula = leer.nextLine();
                    System.out.print("Ingrese el nombre del proveedor: ");
                    String nombre = leer.nextLine();
                    System.out.print("Ingrese el RUC del proveedor: ");
                    String ruc = leer.nextLine();
                    System.out.print("Ingrese el nombre de la empresa: ");
                    String empresa = leer.nextLine();

                    Proveedor nuevoProveedor = new Proveedor(cedula, nombre, ruc, empresa);
                    proveedores.add(nuevoProveedor);

                    System.out.println("Proveedor registrado exitosamente.");
                    break;

                case 2:
                    System.out.println("\n** MOSTRAR PROVEEDORES **");
                    if (proveedores.isEmpty()) {
                        System.out.println("No hay proveedores registrados.");
                    } else {
                        for (int i = 0; i < proveedores.size(); i++) {
                            Proveedor proveedorShow = proveedores.get(i);
                            System.out.println("\nProveedor #" + (i + 1));
                            System.out.println("Nombre: " + proveedorShow.getNombre());
                            System.out.println("Cédula: " + proveedorShow.getCedula());
                            System.out.println("Empresa: " + proveedorShow.getEmpresa());
                            System.out.println("RUC: " + proveedorShow.getRuc());

                            if (proveedorShow.getProductos().isEmpty()) {
                                System.out.println("  No tiene productos registrados.");
                            } else {
                                System.out.println("  Productos registrados:");
                                for (int j = 0; j < proveedorShow.getProductos().size(); j++) {
                                    ProductoFisico producto = (ProductoFisico) proveedorShow.getProductos().get(j);
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
                    System.out.println("\n** BUSCAR PROVEEDOR Y AGREGAR PRODUCTO **");
                    System.out.println("Seleccione el criterio de búsqueda:");
                    System.out.println("1. Buscar por nombre");
                    System.out.println("2. Buscar por cédula");
                    System.out.print("Seleccione una opción: ");
                    int busquedaCriterio = leer.nextInt();
                    leer.nextLine(); // Limpiar buffer
                
                    if (busquedaCriterio == 1) {
                        // Ordenar proveedores por nombre antes de hacer búsqueda binaria
                        Collections.sort(proveedores, Comparator.comparing(Proveedor::getNombre));
                
                        System.out.print("Ingrese el nombre del proveedor a buscar: ");
                        String nombreBusqueda = leer.nextLine();
                
                        // Buscar proveedor por nombre usando búsqueda binaria
                        int indexNombre = Collections.binarySearch(proveedores, new Proveedor(null, nombreBusqueda, null, null), Comparator.comparing(Proveedor::getNombre));
                
                        if (indexNombre >= 0) {
                            Proveedor proveedorEncontrado = proveedores.get(indexNombre);
                            System.out.println("Proveedor encontrado: " + proveedorEncontrado.getNombre());
                
                            // Ahora le permitimos agregar productos al proveedor
                            System.out.print("¿Desea agregar productos a este proveedor? (s/n): ");
                            String respuesta = leer.nextLine();
                
                            if (respuesta.equalsIgnoreCase("s")) {
                                System.out.print("Ingrese el ID del producto (número): ");
                                int id = leer.nextInt();
                                leer.nextLine(); // Limpiar buffer
                                System.out.print("Ingrese el nombre del producto: ");
                                String nombreProducto = leer.nextLine();
                                System.out.print("Ingrese el precio unitario del producto: ");
                                double precioUnitario = leer.nextDouble();
                                System.out.print("Ingrese la cantidad del producto: ");
                                int cantidadProducto = leer.nextInt();
                                leer.nextLine(); // Limpiar buffer
                                System.out.print("Ingrese la descripción del producto: ");
                                String descripcion = leer.nextLine();
                                System.out.print("Ingrese la presentación del producto: ");
                                String presentacion = leer.nextLine();
                
                                ProductoFisico nuevoProducto = new ProductoFisico(id, nombreProducto, precioUnitario, cantidadProducto, descripcion, presentacion);
                                proveedorEncontrado.getProductos().add(nuevoProducto);
                
                                System.out.println("Producto agregado exitosamente al proveedor.");
                                System.out.println("----------------------------------");
                                // Imprimir cálculos de costo con IVA
                                nuevoProducto.calcularCostoIVA();
                            }
                        } else {
                            System.out.println("Proveedor no encontrado.");
                        }
                
                    } else if (busquedaCriterio == 2) {
                        // Ordenar proveedores por cédula antes de hacer búsqueda binaria
                        Collections.sort(proveedores, Comparator.comparing(Proveedor::getCedula));
                
                        System.out.print("Ingrese la cédula del proveedor a buscar: ");
                        String cedulaBusqueda = leer.nextLine();
                
                        // Buscar proveedor por cédula usando búsqueda binaria
                        int indexCedula = Collections.binarySearch(proveedores, new Proveedor(cedulaBusqueda, null, null, null), Comparator.comparing(Proveedor::getCedula));
                
                        if (indexCedula >= 0) {
                            Proveedor proveedorEncontrado = proveedores.get(indexCedula);
                            System.out.println("Proveedor encontrado: " + proveedorEncontrado.getNombre());
                
                            // Ahora le permitimos agregar productos al proveedor
                            System.out.print("¿Desea agregar productos a este proveedor? (s/n): ");
                            String respuesta = leer.nextLine();
                
                            if (respuesta.equalsIgnoreCase("s")) {
                                System.out.print("Ingrese el ID del producto (número): ");
                                int id = leer.nextInt();
                                leer.nextLine(); // Limpiar buffer
                                System.out.print("Ingrese el nombre del producto: ");
                                String nombreProducto = leer.nextLine();
                                System.out.print("Ingrese el precio unitario del producto: ");
                                double precioUnitario = leer.nextDouble();
                                System.out.print("Ingrese la cantidad del producto: ");
                                int cantidadProducto = leer.nextInt();
                                leer.nextLine(); // Limpiar buffer
                                System.out.print("Ingrese la descripción del producto: ");
                                String descripcion = leer.nextLine();
                                System.out.print("Ingrese la presentación del producto: ");
                                String presentacion = leer.nextLine();
                
                                ProductoFisico nuevoProducto = new ProductoFisico(id, nombreProducto, precioUnitario, cantidadProducto, descripcion, presentacion);
                                proveedorEncontrado.getProductos().add(nuevoProducto);
                
                                System.out.println("Producto agregado exitosamente al proveedor.");
                
                                // Imprimir cálculos de costo con IVA
                                nuevoProducto.calcularCostoIVA();
                            }
                        } else {
                            System.out.println("Proveedor no encontrado.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                
                case 4:
                    System.out.println("\n** REGISTRAR SOLICITUD DE COMPRA **");
                    if (proveedores.isEmpty()) {
                        System.out.println("No hay proveedores registrados.");
                        break;
                    }

                    System.out.print("Ingrese el nombre del solicitante: ");
                    String solicitante = leer.nextLine();

                    System.out.println("Seleccione el departamento:");
                    for (DepartamentoEnum dep : DepartamentoEnum.values()) {
                        System.out.println(dep.ordinal() + 1 + ". " + dep.name());
                    }
                    int departamentoOpc = leer.nextInt();
                    DepartamentoEnum departamento = DepartamentoEnum.values()[departamentoOpc - 1];

                    SolicitudCompra nuevaSolicitud = new SolicitudCompra(solicitante, departamento);
                    nuevaSolicitud.setId(solicitudIdCounter); // Asignamos el ID automáticamente
                    solicitudIdCounter++; // Aumentamos el contador para la siguiente solicitud

                    System.out.println("Solicitud registrada exitosamente con ID: " + nuevaSolicitud.getId());

                    System.out.println("Seleccione el proveedor para comprar:");
                    for (int i = 0; i < proveedores.size(); i++) {
                        System.out.println((i + 1) + ". " + proveedores.get(i).getNombre() + " (" + proveedores.get(i).getEmpresa() + ")");
                    }
                    int proveedorSeleccionado = leer.nextInt();
                    leer.nextLine();
                    Proveedor proveedor = proveedores.get(proveedorSeleccionado - 1);

                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < proveedor.getProductos().size(); i++) {
                        System.out.println((i + 1) + ". " + proveedor.getProductos().get(i).getNombre());
                    }

                    boolean seguirComprando = true;
                    while (seguirComprando) {
                        System.out.print("Seleccione el producto: ");
                        int productoSeleccionado = leer.nextInt();
                        Producto producto = proveedor.getProductos().get(productoSeleccionado - 1);

                        System.out.print("Cantidad a comprar: ");
                        int cantidadCompra = leer.nextInt();
                        leer.nextLine();

                        DetalleCompra detalle = new DetalleCompra(producto, cantidadCompra);
                        nuevaSolicitud.getDetalles().add(detalle);

                        System.out.print("¿Desea agregar otro producto? (s/n): ");
                        String respuestaCompra = leer.nextLine();
                        if (respuestaCompra.equalsIgnoreCase("n")) {
                            seguirComprando = false;
                        }
                    }

                    solicitudes.add(nuevaSolicitud);
                    break;

                case 5:
                    System.out.println("\n** BUSCAR SOLICITUD DE COMPRA **");
                    if (solicitudes.isEmpty()) {
                        System.out.println("No hay solicitudes registradas.");
                        break;
                    }

                    System.out.print("Ingrese el ID de la solicitud: ");
                    while (!leer.hasNextInt()) {
                        System.out.println("Error: debe ingresar un número.");
                        leer.next(); // Limpiar buffer si no es un número
                    }
                    int idBusqueda = leer.nextInt();

                    SolicitudCompra solicitudEncontrada = null;
                    for (SolicitudCompra solicitud : solicitudes) {
                        if (solicitud.getId() == idBusqueda) {
                            solicitudEncontrada = solicitud;
                            break;
                        }
                    }

                    if (solicitudEncontrada != null) {
                        System.out.println("\nSolicitud #" + solicitudEncontrada.getId());
                        System.out.println("Solicitante: " + solicitudEncontrada.getSolicitante());
                        System.out.println("Estado: " + solicitudEncontrada.getEstadoSolicitud());
                    } else {
                        System.out.println("Solicitud no encontrada.");
                    }
                    break;

                case 6:
                    System.out.println("¡Gracias por usar el programa!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 6);
        }
    }
}
