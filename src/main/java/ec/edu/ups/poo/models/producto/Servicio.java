package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Servicio extends Producto {
    private String tipo;
    private String categoria;
    private List<Proveedor> proveedores;

    public Servicio() {
        this.proveedores = new ArrayList<>();
    }

    public Servicio(int id, String nombre, double precioUnitario, int cantidad, List<Proveedor> proveedores, String tipo, String categoria) {
        super(id, nombre, precioUnitario, cantidad);
        this.proveedores = proveedores != null ? proveedores : new ArrayList<>();
        this.tipo = tipo;
        this.categoria = categoria;
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
    public double calcularCostoIVA() {
        double costoBase = getPrecioUnitario() * getCantidad();
        return costoBase * 1.12;
    }

    // Insertion Sort por ID
    public void sortByIdInsertion(ArrayList<Servicio> servicios) {
        for (int i = 1; i < servicios.size(); i++) {
            Servicio key = servicios.get(i);
            int j = i - 1;
            while (j >= 0 && servicios.get(j).getId() > key.getId()) {
                servicios.set(j + 1, servicios.get(j));
                j--;
            }
            servicios.set(j + 1, key);
        }
    }

    // Insertion Sort por Nombre
    public void sortByNombreInsertion(ArrayList<Servicio> servicios) {
        for (int i = 1; i < servicios.size(); i++) {
            Servicio key = servicios.get(i);
            int j = i - 1;
            while (j >= 0 && servicios.get(j).getNombre().compareToIgnoreCase(key.getNombre()) > 0) {
                servicios.set(j + 1, servicios.get(j));
                j--;
            }
            servicios.set(j + 1, key);
        }
    }

    // Búsqueda binaria por ID
    public int searchById(ArrayList<Servicio> servicios, int id) {
        int bajo = 0, alto = servicios.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            int idMedio = servicios.get(medio).getId();
            if (idMedio == id) return medio;
            if (idMedio < id) bajo = medio + 1;
            else alto = medio - 1;
        }
        return -1;
    }

    // Búsqueda binaria por Nombre
    public int searchByNombre(ArrayList<Servicio> servicios, String nombre) {
        int bajo = 0, alto = servicios.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            String nombreMedio = servicios.get(medio).getNombre();
            int cmp = nombreMedio.compareToIgnoreCase(nombre);
            if (cmp == 0) return medio;
            if (cmp < 0) bajo = medio + 1;
            else alto = medio - 1;
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
