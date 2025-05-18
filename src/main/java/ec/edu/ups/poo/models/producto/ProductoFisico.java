package ec.edu.ups.poo.models.producto;

import java.util.ArrayList;
import ec.edu.ups.poo.models.Proveedor;

public class ProductoFisico extends Producto {
    private String descripcion;
    private String presentacion;
    private Proveedor proveedor;

    public ProductoFisico() {
    }

    public ProductoFisico(int id, String nombre, double precioUnitario, int cantidad, String descripcion, String presentacion) {
        super(id, nombre, precioUnitario, cantidad);
        this.descripcion = descripcion;
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public double calcularCostoIVA() {
        double costoBase = getPrecioUnitario() * getCantidad();
        double iva = costoBase * 0.12;
        return costoBase + iva;
    }

    // Ordenamiento por ID usando Insertion Sort
    public void sortByIdInsertion(ArrayList<ProductoFisico> productos) {
        for (int i = 1; i < productos.size(); i++) {
            ProductoFisico key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getId() > key.getId()) {
                productos.set(j + 1, productos.get(j));
                j--;
            }
            productos.set(j + 1, key);
        }
    }

    // Ordenamiento por nombre usando Insertion Sort
    public void sortByNombreInsertion(ArrayList<ProductoFisico> productos) {
        for (int i = 1; i < productos.size(); i++) {
            ProductoFisico key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getNombre().compareToIgnoreCase(key.getNombre()) > 0) {
                productos.set(j + 1, productos.get(j));
                j--;
            }
            productos.set(j + 1, key);
        }
    }

    // Búsqueda binaria por ID
    public int searchById(ArrayList<ProductoFisico> productos, int id) {
        int bajo = 0;
        int alto = productos.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            int idMedio = productos.get(medio).getId();
            if (idMedio == id) {
                return medio;
            } else if (idMedio < id) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }

    // Búsqueda binaria por nombre
    public int searchByNombre(ArrayList<ProductoFisico> productos, String nombre) {
        int bajo = 0;
        int alto = productos.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            String nombreMedio = productos.get(medio).getNombre();
            int comparacion = nombreMedio.compareToIgnoreCase(nombre);
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "\n========= PRODUCTO =========\n" +
            "ID           : " + getId() + "\n" +
            "Nombre       : " + getNombre() + "\n" +
            "Precio Unit. : $" + String.format("%.2f", getPrecioUnitario()) + "\n" +
            "Cantidad     : " + getCantidad() + "\n" +
            "Descripción  : " + descripcion + "\n" +
            "Presentación : " + presentacion + "\n" +
            "=============================\n";
    }
}