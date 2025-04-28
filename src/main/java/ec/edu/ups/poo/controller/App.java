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
            Scanner leer = new Scanner(System.in); 
            ArrayList<Proveedor> proveedores = new ArrayList<>();
            ArrayList<ProductoFisico> productos = new ArrayList<>();
            ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
            ArrayList<Servicio> servicios = new ArrayList<>();
            ArrayList<Departamento> departamentos = new ArrayList<>();
            Proveedor proveedorG = new Proveedor();
            ProductoFisico productoFisico =new ProductoFisico();
            Servicio servicioG = new Servicio();
            SolicitudCompra solicitudG = new SolicitudCompra();

            int solicitudIdCounter = 1;

            do {
                System.out.println("===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
                System.out.println("0. Registrar departamento");
                System.out.println("1. Registrar proveedor");
                System.out.println("2. Registrar producto");
                System.out.println("3. Registrar solicitud de compra");
                System.out.println("4. Listar proveedores");
                System.out.println("5. Listar productos");
                System.out.println("6. Listar solicitudes de compra");
                System.out.println("7. Buscar proveedor");
                System.out.println("8. Buscar producto");
                System.out.println("9. Buscar solicitud");
                System.out.println("10. Actualizar solicitud");
                System.out.println("11. Calcular total de una solicitud");
                System.out.println("12. Salir");
                System.out.print("Seleccione una opción: ");

                while (!leer.hasNextInt()) {
                    System.out.println("Error: debe ingresar un número.");
                    leer.next();
                }
                option = leer.nextInt();
                leer.nextLine();
                switch (option) {
                    case 0:
                        System.out.println("** REGISTRAR DEPARTAMENTO **");
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
                        System.out.println("** REGISTRAR PROVEEDOR **");
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
                        System.out.println("** REGISTRAR PRODUCTO **");
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
                            String nombreProducto = leer.next();
                            System.out.print("Ingrese precio unitario: ");
                            double precio = leer.nextDouble();
                            System.out.print("Ingrese cantidad: ");
                            int cantidad = leer.nextInt();
                            leer.nextLine();
                            System.out.print("Ingrese descripción: ");
                            String descripcion = leer.next();
                            System.out.print("Ingrese presentación: ");
                            String presentacion = leer.next();

                            // Mostrar lista de proveedores
                            System.out.println("Seleccione un proveedor:");
                            for (int i = 0; i < proveedores.size(); i++) {
                                System.out.println((i + 1) + ". " + proveedores.get(i).getNombre());
                            }
                            int proveedorIndex = leer.nextInt() - 1;
                            Proveedor proveedorSeleccionado = proveedores.get(proveedorIndex);

                            ProductoFisico producto = new ProductoFisico(id, nombreProducto, precio, cantidad, descripcion, presentacion);
                            producto.setProveedor(proveedorSeleccionado); 

                            productos.add(producto);
                            System.out.println("Producto registrado correctamente.");
                        } else if (tipoProducto == 2) {
                            System.out.print("Ingrese el ID del servicio: ");
                            int idServicio = leer.nextInt();
                            leer.next();
                            System.out.print("Ingrese el nombre del servicio: ");
                            String nombreServicio = leer.next();
                            System.out.print("Ingrese precio unitario: ");
                            int precioServicio = leer.nextInt();
                            System.out.print("Ingrese cantidad: ");
                            int cantidadServicio = leer.nextInt();
                            leer.next();
                            System.out.print("Ingrese tipo del servicio: ");
                            String tipoServicio = leer.next();
                            System.out.print("Ingrese categoría del servicio: ");
                            String categoriaServicio = leer.nextLine();

                            // Mostrar lista de proveedores
                            System.out.println("Seleccione un proveedor:");
                            for (int i = 0; i < proveedores.size(); i++) {
                                System.out.println((i + 1) + ". " + proveedores.get(i).getNombre());
                            }
                            int proveedorIndex = leer.nextInt() - 1;
                            Proveedor proveedorSeleccionado = proveedores.get(proveedorIndex);

                            ArrayList<Proveedor> proveedorLista = new ArrayList<>();
                            proveedorLista.add(proveedorSeleccionado);

                            Servicio servicio = new Servicio(idServicio, nombreServicio, precioServicio, cantidadServicio, proveedorLista, tipoServicio, categoriaServicio);
                            servicios.add(servicio);
                            System.out.println("Servicio registrado correctamente.");
                        }
                        break;



                        case 3: 
                        System.out.println("** REGISTRAR SOLICITUD DE COMPRA **");
                        
                        if (productos.isEmpty() && servicios.isEmpty()) {
                            System.out.println("Debe registrar productos o servicios primero.");
                            break;
                        }
                        if (departamentos.isEmpty()) {
                            System.out.println("Debe registrar departamentos primero.");
                            break;
                        }
                    
                        System.out.print("Ingrese el nombre del solicitante: ");
                        leer.nextLine(); // limpiar buffer antes de nextLine
                        String solicitante = leer.next();

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
                            System.out.println("¿Qué desea agregar?");
                            if (!productos.isEmpty()) {
                                System.out.println("1. Producto");
                            }
                            if (!servicios.isEmpty()) {
                                System.out.println("2. Servicio");
                            }
                            System.out.print("Seleccione una opción: ");
                            int tipo = leer.nextInt();
                            leer.nextLine(); // limpiar buffer
                    
                            if (tipo == 1 && !productos.isEmpty()) {
                                System.out.println("Seleccione un producto:");
                                for (int i = 0; i < productos.size(); i++) {
                                    System.out.println((i + 1) + ". " + productos.get(i).getNombre());
                                }
                                int productoIndex = leer.nextInt() - 1;
                                leer.nextLine(); // limpiar buffer
                    
                                if (productoIndex >= 0 && productoIndex < productos.size()) {
                                    Producto productoSeleccionado = productos.get(productoIndex);
                    
                                    System.out.print("Ingrese la cantidad: ");
                                    int cantidadDetalle = leer.nextInt();
                                    leer.nextLine(); // limpiar buffer
                    
                                    solicitud.getDetalles().add(new DetalleCompra(productoSeleccionado, cantidadDetalle));
                                } else {
                                    System.out.println("Producto no válido. Intente nuevamente.");
                                    continue;
                                }
                    
                            } else if (tipo == 2 && !servicios.isEmpty()) {
                                System.out.println("Seleccione un servicio:");
                                for (int i = 0; i < servicios.size(); i++) {
                                    System.out.println((i + 1) + ". " + servicios.get(i).getNombre());
                                }
                                int servicioIndex = leer.nextInt() - 1;
                                leer.nextLine(); // limpiar buffer
                    
                                if (servicioIndex >= 0 && servicioIndex < servicios.size()) {
                                    Servicio servicioSeleccionado = servicios.get(servicioIndex);
                    
                                    System.out.print("Ingrese la cantidad: ");
                                    int cantidadDetalle = leer.nextInt();
                                    leer.nextLine(); // limpiar buffer
                    
                                    solicitud.getDetalles().add(new DetalleCompra(servicioSeleccionado, cantidadDetalle));
                                } else {
                                    System.out.println("Servicio no válido. Intente nuevamente.");
                                    continue;
                                }
                            } else {
                                System.out.println("Opción no válida o no disponible. Intente nuevamente.");
                                continue;
                            }
                    
                            System.out.print("¿Desea agregar otro producto o servicio? (s/n): ");
                            String continuar = leer.next();
                            agregarProductos = continuar.equalsIgnoreCase("s");
                        }
                    
                        solicitudes.add(solicitud);
                        System.out.println("Solicitud registrada exitosamente con ID: " + solicitud.getId());
                        break;
                    

                        case 4:
                        System.out.println("** LISTAR PROVEEDORES **");
                        if (proveedores.isEmpty()) {
                            System.out.println("No hay proveedores registrados.");
                        } else {
                            for (Proveedor p : proveedores) {
                                System.out.println(p); 
                                System.out.println("Productos y Servicios asociados:");
                    
                                boolean tieneProductosOServicios = false;
                    
                                for (ProductoFisico prod : productos) {
                                    if (prod.getProveedor().equals(p)) {
                                        System.out.println("- Producto Físico: " + prod.getNombre());
                                        tieneProductosOServicios = true; 
                                    }
                                }
                    
                                for (Servicio serv : servicios) {
                                    if (serv.getProveedores().contains(p)) {
                                        System.out.println("- Servicio: " + serv.getNombre());
                                        tieneProductosOServicios = true; 
                                    }
                                }
                    
                                if (!tieneProductosOServicios) {
                                    System.out.println("  (No tiene productos ni servicios asociados)");
                                }
                            }
                        }
                        break;
                    
                    

                        case 5:
                        System.out.println("** LISTAR PRODUCTOS Y SERVICIOS **");
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
                        System.out.println("** LISTA DE SOLICITUDES DE COMPRA **");
                        if (solicitudes.isEmpty()) {
                            System.out.println("No hay solicitudes registradas.");
                        } else {
                            for (SolicitudCompra solicitudItem : solicitudes) {
                                System.out.println(solicitudItem);
                            }
                        }
                        break;
                    
                    
                    

                    case 7: 
                        System.out.println("** BUSCAR PROVEEDOR **");
                        System.out.println("Quieres Buscar por:");
                        System.out.println("1. Cédula");
                        System.out.println("2. Nombre");
                        System.out.print("Seleccione una opción: ");
                        int opcionBuscar = leer.nextInt();
                        if (opcionBuscar == 1){
                            System.out.print("Ingrese la cédula del proveedor: ");
                            String cedulaBuscar = leer.next();
                            proveedorG.sortByCedulaInsertion(proveedores);
                            int index = proveedorG.searchByCedula(proveedores, cedulaBuscar);
                            if (index != -1) {
                                System.out.println("Proveedor encontrado: " + proveedores.get(index));
                            } else {
                                System.out.println("Proveedor no encontrado.");
                            }
                        }
                        break;

                    case 8:
                        System.out.println("** BUSCAR PRODUCTO **");
                        System.out.println("Quieres Buscar por:");
                        System.out.println("1. Nombre");
                        System.out.println("2. ID");
                        System.out.print("Seleccione una opción: ");
                        int opcionBuscarProducto = leer.nextInt();
                        if (opcionBuscarProducto==1){
                            System.out.println("Es Servicio o Producto Fisico?");
                            System.out.println("1. Producto Fisico");
                            System.out.println("2. Servicio");
                            int tipoProductoBuscar = leer.nextInt();
                            if (tipoProductoBuscar==1){
                                System.out.print("Ingrese el nombre del producto: ");
                                String nombreBuscar = leer.next();
                                productoFisico.sortByNombreInsertion(productos);
                                int index = productoFisico.searchByNombre(productos, nombreBuscar);
                                if (index != -1) {
                                    System.out.println("Producto encontrado: " + productos.get(index));
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                                
                            }else if (tipoProductoBuscar==2){
                                System.out.print("Ingrese el nombre del servicio: ");
                                String nombreBuscar = leer.next();
                                servicioG.sortByNombreInsertion(servicios);
                                int index = servicioG.searchByNombre(servicios, nombreBuscar);
                                if (index != -1) {
                                    System.out.println("Servicio encontrado: " + servicios.get(index));
                                } else {
                                    System.out.println("Servicio no encontrado.");
                                }
                            }
                        } else if (opcionBuscarProducto==2){
                            System.out.println("Es Servicio o Producto Fisico?");
                            System.out.println("1. Producto Fisico");
                            System.out.println("2. Servicio");
                            int tipoProductoBuscar = leer.nextInt();
                            if (tipoProductoBuscar==1){
                                System.out.print("Ingrese el ID del producto: ");
                                int idBuscar = leer.nextInt();
                                productoFisico.sortByIdInsertion(productos);
                                int index = productoFisico.searchById(productos, idBuscar);
                                if (index != -1) {
                                    System.out.println("Producto encontrado: " + productos.get(index));
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                                
                            }else if (tipoProductoBuscar==2){
                                System.out.print("Ingrese el ID del servicio: ");
                                int idBuscar = leer.nextInt();
                                servicioG.sortByIdInsertion(servicios);
                                int index = servicioG.searchById(servicios, idBuscar);
                                if (index != -1) {
                                    System.out.println("Servicio encontrado: " + servicios.get(index));
                                } else {
                                    System.out.println("Servicio no encontrado.");
                                }
                            }
                        }
                        break;

                    case 9:
                        System.out.println("** BUSCAR SOLICITUD**");
                        System.out.print("Ingrese el ID de la solicitud: ");
                        int idBuscarSolicitud = leer.nextInt();
                        solicitudG.sortByIdInsertion(solicitudes);
                        solicitudG.searchById(solicitudes, idBuscarSolicitud);
                        int indexSolicitud = solicitudG.searchById(solicitudes, idBuscarSolicitud);
                        if (indexSolicitud != -1) {
                            System.out.println("Solicitud encontrada: " + solicitudes.get(indexSolicitud));
                        } else {
                            System.out.println("Solicitud no encontrada.");
                        }
                        break;

                    case 10:
                        System.out.println("** ACTUALIZAR SOLICITUD **");
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

                    case 11:
                        System.out.println("** CALCULAR TOTAL DE UNA SOLICITUD **");
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

                    case 12:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }

            } while (option != 12);
        
    }
}
