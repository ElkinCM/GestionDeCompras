package ec.edu.ups.poo.controller;

import ec.edu.ups.poo.models.producto.ProductoFisico;
import ec.edu.ups.poo.models.producto.Servicio;
import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.Proveedor;
import ec.edu.ups.poo.models.DetalleCompra;
import ec.edu.ups.poo.models.SolicitudCompra;
import ec.edu.ups.poo.models.Departamento;
import ec.edu.ups.poo.models.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int option = 0;
        try (Scanner leer = new Scanner(System.in)) {
            ArrayList<Proveedor> proveedores = new ArrayList<>();
            ArrayList<ProductoFisico> productos = new ArrayList<>();
            ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
            ArrayList<Servicio> servicios = new ArrayList<>();
            ArrayList<Departamento> departamentos = new ArrayList<>();
            int solicitudIdCounter = 1;

            do {
                System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
                System.out.println("0. Registrar departamento");
                System.out.println("1. Registrar proveedor");
                System.out.println("2. Registrar producto");
                System.out.println("3. Registrar solicitud de compra");
                System.out.println("4. Listar proveedores");
                System.out.println("5. Listar productos");
                System.out.println("6. Listar solicitudes de compra");
                System.out.println("7. Buscar proveedor por ID");
                System.out.println("8. Buscar producto por nombre");
                System.out.println("9. Buscar solicitud por número");
                System.out.println("13. Aprobar / Rechazar solicitud de compra");
                System.out.println("14. Calcular total de una solicitud");
                System.out.println("15. Salir");
                System.out.print("Seleccione una opción: ");

                while (!leer.hasNextInt()) {
                    System.out.println("Error: debe ingresar un número.");
                    leer.next();
                }
                option = leer.nextInt();
                leer.nextLine();
                switch (option) {
                    case 0:
                        System.out.println("\n** REGISTRAR DEPARTAMENTO **");
                        System.out.print("Ingrese nombre del departamento: ");
                        String nombreDp = leer.nextLine();
                        System.out.print("Ingrese descripción: ");
                        String descripcionDp = leer.nextLine();
                        System.out.print("Ingrese presupuesto: ");
                        String presupuestoDp = leer.nextLine();
                        Departamento nuevoDepartamento = new Departamento(nombreDp, descripcionDp, presupuestoDp);
                        departamentos.add(nuevoDepartamento);
                        System.out.println("Departamento registrado exitosamente.");
                        break;

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
                        Proveedor proveedor = new Proveedor(cedula, nombre, ruc, empresa);
                        proveedores.add(proveedor);
                        System.out.println("Proveedor registrado exitosamente.");
                        break;

                        case 2:
                        System.out.println("\n** REGISTRAR PRODUCTO **");
                        if (proveedores.isEmpty()) {
                            System.out.println("Debe registrar un proveedor primero.");
                            break;
                        }
                        System.out.println("Seleccione el tipo de producto a registrar:");
                        System.out.println("1. Producto Físico");
                        System.out.println("2. Servicio");
                        int tipoProducto = leer.nextInt();
                        leer.nextLine();

                        if (tipoProducto == 1) {
                            System.out.print("Ingrese el ID del producto: ");
                            int id = leer.nextInt();
                            leer.nextLine();
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombreProducto = leer.nextLine();
                            System.out.print("Ingrese precio unitario: ");
                            double precio = leer.nextDouble();
                            System.out.print("Ingrese cantidad: ");
                            int cantidad = leer.nextInt();
                            leer.nextLine();
                            System.out.print("Ingrese descripción: ");
                            String descripcion = leer.nextLine();
                            System.out.print("Ingrese presentación: ");
                            String presentacion = leer.nextLine();
                            ProductoFisico producto = new ProductoFisico(id, nombreProducto, precio, cantidad, descripcion, presentacion);
                            productos.add(producto);
                            System.out.println("Producto registrado correctamente.");
                        } else if (tipoProducto == 2) {
                            System.out.print("Ingrese el ID del servicio: ");
                            int idServicio = leer.nextInt();
                            leer.nextLine(); 
                            System.out.print("Ingrese el nombre del servicio: ");
                            String nombreServicio = leer.nextLine();
                            System.out.print("Ingrese precio unitario: ");
                            int precioServicio = leer.nextInt();
                            System.out.print("Ingrese cantidad: ");
                            int cantidadServicio = leer.nextInt();
                            leer.nextLine(); 
                            System.out.print("Ingrese tipo del servicio: ");
                            String tipoServicio = leer.nextLine();
                            System.out.print("Ingrese categoría del servicio: ");
                            String categoriaServicio = leer.nextLine();
                            
                            Servicio servicio = new Servicio(idServicio, nombreServicio, precioServicio, cantidadServicio, proveedores, tipoServicio, categoriaServicio);
                            servicios.add(servicio);
                            System.out.println("Servicio registrado correctamente.");
                        }
                        break;


                    case 3: 
                        System.out.println("\n** REGISTRAR SOLICITUD DE COMPRA **");
                        if (productos.isEmpty()) {
                            System.out.println("Debe registrar productos primero.");
                            break;
                        }
                        if (departamentos.isEmpty()) {
                            System.out.println("Debe registrar departamentos primero.");
                            break;
                        }
                        System.out.print("Ingrese el nombre del solicitante: ");
                        String solicitante = leer.nextLine();
                        System.out.println("Seleccione el departamento:");
                        for (int i = 0; i < departamentos.size(); i++) {
                            System.out.println((i + 1) + ". " + departamentos.get(i).getNombreDp());
                        }
                        int depSeleccion = leer.nextInt();
                        Departamento departamentoSeleccionado = departamentos.get(depSeleccion - 1);
                        SolicitudCompra solicitud = new SolicitudCompra(solicitante, departamentoSeleccionado);
                        solicitud.setId(solicitudIdCounter++);

                        boolean agregarProductos = true;
                        while (agregarProductos) {
                            System.out.println("Seleccione un producto:");
                            for (int i = 0; i < productos.size(); i++) {
                                System.out.println((i + 1) + ". " + productos.get(i).getNombre());
                            }
                            int productoIndex = leer.nextInt() - 1;
                            Producto productoSeleccionado = productos.get(productoIndex);

                            System.out.print("Ingrese la cantidad: ");
                            int cantidadDetalle = leer.nextInt();
                            solicitud.getDetalles().add(new DetalleCompra(productoSeleccionado, cantidadDetalle));

                            System.out.print("¿Desea agregar otro producto? (s/n): ");
                            leer.nextLine();
                            String continuar = leer.nextLine();
                            agregarProductos = continuar.equalsIgnoreCase("s");
                        }

                        solicitudes.add(solicitud);
                        System.out.println("Solicitud registrada exitosamente con ID: " + solicitud.getId());
                        break;

                    case 4:
                        System.out.println("\n** LISTAR PROVEEDORES **");
                        if (proveedores.isEmpty()) {
                            System.out.println("No hay proveedores registrados.");
                        } else {
                            for (Proveedor p : proveedores) {
                                System.out.println(p);
                            }
                        }
                        break;

                        case 5:
                        System.out.println("\n** LISTAR PRODUCTOS Y SERVICIOS **");
                        if (productos.isEmpty() && servicios.isEmpty()) {
                            System.out.println("No hay productos ni servicios registrados.");
                        } else {
                            System.out.println("Productos físicos:");
                            for (ProductoFisico p : productos) {
                                System.out.println(p);
                            }
                    
                            System.out.println("Servicios:");
                            for (Servicio s : servicios) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 6:
                        System.out.println("\n** LISTAR SOLICITUDES DE COMPRA **");
                        if (solicitudes.isEmpty()) {
                            System.out.println("No hay solicitudes registradas.");
                        } else {
                            for (SolicitudCompra s : solicitudes) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 7: 
                        System.out.println("\n** BUSCAR PROVEEDOR POR ID **");
                        System.out.print("Ingrese la cédula del proveedor: ");
                        String buscarCedula = leer.nextLine();
                        Proveedor encontrado = null;
                        for (Proveedor p : proveedores) {
                            if (p.getCedula().equals(buscarCedula)) {
                                encontrado = p;
                                break;
                            }
                        }
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Proveedor no encontrado.");
                        }
                        break;

                    case 8:
                        System.out.println("\n** BUSCAR PRODUCTO POR NOMBRE **");
                        System.out.print("Ingrese el nombre del producto: ");
                        String buscarNombre = leer.nextLine();
                        ProductoFisico productoEncontrado = null;
                        for (ProductoFisico p : productos) {
                            if (p.getNombre().equalsIgnoreCase(buscarNombre)) {
                                productoEncontrado = p;
                                break;
                            }
                        }
                        if (productoEncontrado != null) {
                            System.out.println(productoEncontrado);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;

                    case 9:
                        System.out.println("\n** BUSCAR SOLICITUD POR NÚMERO **");
                        System.out.print("Ingrese el ID de la solicitud: ");
                        int buscarId = leer.nextInt();
                        SolicitudCompra solicitudBuscada = null;
                        for (SolicitudCompra s : solicitudes) {
                            if (s.getId() == buscarId) {
                                solicitudBuscada = s;
                                break;
                            }
                        }
                        if (solicitudBuscada != null) {
                            System.out.println(solicitudBuscada);
                        } else {
                            System.out.println("Solicitud no encontrada.");
                        }
                        break;

                    case 13:
                        System.out.println("\n** APROBAR/RECHAZAR SOLICITUD **");
                        System.out.print("Ingrese el ID de la solicitud: ");
                        int idSolicitud = leer.nextInt();
                        SolicitudCompra solicitudActualizar = null;
                        for (SolicitudCompra s : solicitudes) {
                            if (s.getId() == idSolicitud) {
                                solicitudActualizar = s;
                                break;
                            }
                        }
                        if (solicitudActualizar != null) {
                            System.out.println("Estado actual: " + solicitudActualizar.getEstadoSolicitud());
                            System.out.println("1. Aprobar");
                            System.out.println("2. Rechazar");
                            int opcionEstado = leer.nextInt();
                            if (opcionEstado == 1) {
                                solicitudActualizar.setEstado(EstadoSolicitud.APROBADA);
                            } else if (opcionEstado == 2) {
                                solicitudActualizar.setEstado(EstadoSolicitud.RECHAZADA);
                            } else {
                                System.out.println("Opción inválida.");
                            }
                            System.out.println("Estado actualizado.");
                        } else {
                            System.out.println("Solicitud no encontrada.");
                        }
                        break;

                    case 14:
                        System.out.println("\n** CALCULAR TOTAL DE UNA SOLICITUD **");
                        System.out.print("Ingrese el ID de la solicitud: ");
                        int idCalcular = leer.nextInt();
                        SolicitudCompra solicitudCalcular = null;
                        for (SolicitudCompra s : solicitudes) {
                            if (s.getId() == idCalcular) {
                                solicitudCalcular = s;
                                break;
                            }
                        }
                        if (solicitudCalcular != null) {
                            double subtotal = solicitudCalcular.calcularTotal();
                            double iva = subtotal * 0.12;
                            double total = subtotal + iva;
                            System.out.println("Subtotal: $" + subtotal);
                            System.out.println("IVA (12%): $" + iva);
                            System.out.println("Total a pagar: $" + total);
                        } else {
                            System.out.println("Solicitud no encontrada.");
                        }
                        break;

                    case 15:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }

            } while (option != 15);
        }
    }
}
