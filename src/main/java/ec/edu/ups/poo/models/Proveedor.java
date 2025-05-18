package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.producto.ProductoFisico;
import ec.edu.ups.poo.models.producto.Servicio;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {
    private String empresa;
    private List<Producto> productos = new ArrayList<>();

    public Proveedor(String cedula, String nombre, String empresa) {
        super(cedula, nombre);
        this.empresa = empresa;
    }

    public Proveedor() {
        super("", "");
    }

    public String getEmpresa() {
        return empresa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }
    public void ordenarPorCedula(List<Proveedor> proveedores) {
        for (int i = 1; i < proveedores.size(); i++) {
            Proveedor key = proveedores.get(i);
            int j = i - 1;
            while (j >= 0 && proveedores.get(j).getCedula().compareTo(key.getCedula()) > 0) {
                proveedores.set(j + 1, proveedores.get(j));
                j--;
            }
            proveedores.set(j + 1, key);
        }
    }

    public int buscarPorCedula(List<Proveedor> proveedores, String cedula) {
        int bajo = 0, alto = proveedores.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            int comparacion = proveedores.get(medio).getCedula().compareTo(cedula);
            if (comparacion == 0) return medio;
            if (comparacion < 0) bajo = medio + 1;
            else alto = medio - 1;
        }
        return -1;
    }

    public static void listarProveedoresConProductos(
            List<Proveedor> proveedores,
            List<ProductoFisico> productosFisicos,
            List<Servicio> servicios
    ) {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        for (Proveedor p : proveedores) {
            System.out.println(p);

            boolean tieneAsociados = false;

            if (p.getProductos() != null && !p.getProductos().isEmpty()) {
                System.out.println("Productos registrados:");
                for (Producto producto : p.getProductos()) {
                    System.out.println(" - " + producto.getNombre());
                }
                tieneAsociados = true;
            }

            for (ProductoFisico pf : productosFisicos) {
                if (pf.getProveedor().equals(p)) {
                    if (!tieneAsociados) {
                        System.out.println("Productos y Servicios asociados:");
                    }
                    System.out.println("- Producto Físico: " + pf.getNombre());
                    tieneAsociados = true;
                }
            }

            for (Servicio serv : servicios) {
                if (serv.getProveedores().contains(p)) {
                    if (!tieneAsociados) {
                        System.out.println("Productos y Servicios asociados:");
                    }
                    System.out.println("- Servicio: " + serv.getNombre());
                    tieneAsociados = true;
                }
            }

            if (!tieneAsociados) {
                System.out.println("No tiene productos ni servicios asociados.");
            }

            System.out.println("----------------------------------");
        }
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
    
    @Override
    public String toString() {
        return "\n========= PROVEEDOR =========\n" +
            "Cédula      : " + getCedula() + "\n" +
            "Nombre      : " + getNombre() + "\n" +
            "Empresa     : " + empresa + "\n" +
            "==============================\n";
    }
}
