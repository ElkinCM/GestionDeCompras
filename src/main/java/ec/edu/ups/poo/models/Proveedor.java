package ec.edu.ups.poo.models;

import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.poo.models.producto.Producto;

public class Proveedor extends Persona {
    private String ruc;
    private String empresa;
    private List<Producto> productos;
    public Proveedor() {
    }

    public Proveedor(String cedula, String nombre, String ruc, String empresa) {
        super(cedula, nombre);
        this.ruc = ruc;
        this.empresa = empresa;
        this.productos = new ArrayList<>();
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String obtenerEmpresa() {
        return empresa;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void sortByNameInsertion(Proveedor[] proveedores) {
        for (int i = 1; i < proveedores.length; i++) {
            Proveedor key = proveedores[i];
            int j = i - 1;
            while (j >= 0 && proveedores[j].getNombre().compareTo(key.getNombre()) > 0) {
                proveedores[j + 1] = proveedores[j];
                j = j - 1;
            }
            proveedores[j + 1] = key;
        }
    }
    public void sortByCedulaInsertion(Proveedor[] proveedores) {
        for (int i = 1; i < proveedores.length; i++) {
            Proveedor key = proveedores[i];
            int j = i - 1;
            while (j >= 0 && proveedores[j].getCedula().compareTo(key.getCedula()) > 0) {
                proveedores[j + 1] = proveedores[j];
                j = j - 1;
            }
            proveedores[j + 1] = key;
        }
    }


    public int searchByName(Proveedor[] proveedores, String nombre){
        int bajo = 0;
        int alto = proveedores.length - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (proveedores[medio].getNombre().equalsIgnoreCase(nombre)) {
                return medio;
            } else if (proveedores[medio].getNombre().compareToIgnoreCase(nombre) < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1; 
            }
        }
        return -1;
    }

    public int searchByCedula(Proveedor[] proveedores, String cedula){
        int bajo = 0;
        int alto = proveedores.length - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (proveedores[medio].getCedula().equalsIgnoreCase(cedula)) {
                return medio;
            } else if (proveedores[medio].getCedula().compareToIgnoreCase(cedula) < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        } else {
            System.out.println("El producto no puede ser nulo.");
        }
    }

    public void eliminarProducto(Producto producto) {
        if (productos.contains(producto)) {
            productos.remove(producto);
        } else {
            System.out.println("El producto no se encuentra en la lista de productos del proveedor.");
        }
    }

    @Override
    public String toString() {
        return "\n========= PROVEEDOR =========\n" +
            "Cédula      : " + getCedula() + "\n" +
            "Nombre      : " + getNombre() + "\n" +
            "RUC         : " + ruc + "\n" +
            "Empresa     : " + empresa + "\n" +
            "==============================\n";
    }
    
}
