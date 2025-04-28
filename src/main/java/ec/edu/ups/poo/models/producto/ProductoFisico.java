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

        public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
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

    @Override
    public int calcularCostoIVA() {
        double costoBase = getPrecioUnitario() * getCantidad();  // Costo sin IVA
        double iva = costoBase * 0.12;  // 12% IVA
        double costoTotalConIVA = costoBase + iva;  // Precio total con IVA
    
        // Imprimir los cálculos en consola
        System.out.println("Cálculos para el producto: " + getNombre());
        System.out.println("Precio Unitario: " + getPrecioUnitario());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Costo Base (Precio Unitario * Cantidad): " + costoBase);
        System.out.println("IVA (12% del Costo Base): " + iva);
        System.out.println("Costo Total con IVA: " + costoTotalConIVA);
    
        return (int) costoTotalConIVA;  // Convertimos a entero si lo deseas
    }

    public void sortByIdInsertion(ArrayList<ProductoFisico> productos) {
        for (int i = 1; i < productos.size(); i++) {
            ProductoFisico key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getId() > key.getId()) {
                productos.set(j + 1, productos.get(j));
                j = j - 1;
            }
            productos.set(j + 1, key);
        }
    }
    public void sortByNombreInsertion(ArrayList<ProductoFisico> productos) {
        for (int i = 1; i < productos.size(); i++) {
            ProductoFisico key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getNombre().compareTo(key.getNombre()) > 0) {
                productos.set(j + 1, productos.get(j));
                j = j - 1;
            }
            productos.set(j + 1, key);
        }
    }
    public int searchById(ArrayList<ProductoFisico> productos, int id) {
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
        }return -1; 
    }
    public int searchByNombre(ArrayList<ProductoFisico> productos, String nombre) {
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
    return -1;}
    
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