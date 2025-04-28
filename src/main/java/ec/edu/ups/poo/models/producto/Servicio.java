package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Servicio extends Producto {
    private String tipo;
    private String categoria;
    private List<Proveedor> proveedores = new ArrayList<>();
    
    public Servicio() {
    }

    public Servicio(int id, String nombre, int precioUnitario, int cantidad, List<Proveedor> proveedores, String tipo, String categoria) {
        super(id, nombre, precioUnitario, cantidad);
        this.tipo = tipo;
        this.categoria = categoria;
        this.proveedores = proveedores;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int calcularCostoIVA() {
        return (int) (getPrecioUnitario() * getCantidad() * 1.12);
    }

    public void sortByIdInsertion(ArrayList<Servicio> productos) {
        for (int i = 1; i < productos.size(); i++) {
            Servicio key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getId() > key.getId()) {
                productos.set(j + 1, productos.get(j));
                j = j - 1;
            }
            productos.set(j + 1, key);
        }
    }

    public void sortByNombreInsertion(ArrayList<Servicio> productos) {
        for (int i = 1; i < productos.size(); i++) {
            Servicio key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getNombre().compareTo(key.getNombre()) > 0) {
                productos.set(j + 1, productos.get(j));
                j = j - 1;
            }
            productos.set(j + 1, key);
        }
    }

    public int searchById(ArrayList<Servicio> productos, int id) {
        int bajo = 0;
        int alto = productos.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (productos.get(medio).getId() == id) {
                return medio; 
            } else if (productos.get(medio).getId() < id) {
                bajo = medio + 1; 
            } else {
                alto = medio - 1; 
            }
        }
        return -1;
    }

    public int searchByNombre(ArrayList<Servicio> productos, String nombre) {
        int bajo = 0;
        int alto = productos.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (productos.get(medio).getNombre().equalsIgnoreCase(nombre)) {
                return medio;
            } else if (productos.get(medio).getNombre().compareToIgnoreCase(nombre) < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "\n========= SERVICIO =========\n" +
                "ID            : " + getId() + "\n" +
                "Nombre        : " + getNombre() + "\n" +
                "Precio Unit.  : $" + String.format("%.2f", getPrecioUnitario()) + "\n" +
                "Cantidad      : " + getCantidad() + "\n" +
                "Tipo          : " + tipo + "\n" +
                "Categoría     : " + categoria + "\n" +
                "=============================\n";
    }
}
