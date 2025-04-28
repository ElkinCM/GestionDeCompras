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

    public  void sortByNameInsertion(ArrayList<Proveedor> proveedores) {
        for (int i = 1; i < proveedores.size(); i++) {
            Proveedor key = proveedores.get(i);
            int j = i - 1;
            while (j >= 0 && proveedores.get(j).getNombre().compareTo(key.getNombre()) > 0) {
                proveedores.set(j + 1, proveedores.get(j));
                j = j - 1;
            }
            proveedores.set(j + 1, key);
        }
    }
    public void sortByCedulaInsertion(ArrayList<Proveedor> proveedores) {
        for (int i = 1; i < proveedores.size(); i++) {
            Proveedor key = proveedores.get(i);
            int j = i - 1;
            while (j >= 0 && proveedores.get(j).getCedula().compareTo(key.getCedula()) > 0) {
                proveedores.set(j + 1, proveedores.get(j));
                j = j - 1;
            }
            proveedores.set(j + 1, key);
        }
    }


    public int searchByName(ArrayList<Proveedor> proveedores, String nombre){
        int bajo = 0;
        int alto = proveedores.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (proveedores.get(medio).getNombre().equalsIgnoreCase(nombre)) {
                return medio; // Se encontró el nombre
            } else if (proveedores.get(medio).getNombre().compareToIgnoreCase(nombre) < 0) {
                bajo = medio + 1; // Buscar en la mitad superior
            } else {
                alto = medio - 1; // Buscar en la mitad inferior
            }
        }
        return -1; 
    }

    public int searchByCedula(ArrayList<Proveedor> proveedores, String cedula){
        int bajo = 0;
        int alto = proveedores.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (proveedores.get(medio).getCedula().equalsIgnoreCase(cedula)) {
                return medio;
            } else if (proveedores.get(medio).getCedula().compareToIgnoreCase(cedula) < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        };
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
