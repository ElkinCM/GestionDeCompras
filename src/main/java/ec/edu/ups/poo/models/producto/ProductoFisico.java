package ec.edu.ups.poo.models.producto;

import java.util.List;
import ec.edu.ups.poo.models.Proveedor;

public class ProductoFisico extends Producto {
    private String descripcion;
    private String presentacion;

    public ProductoFisico() {
    }

    public ProductoFisico(int id, String nombre, int precioUnitario, int cantidad, String descripcion, String presentacion) {
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

    @Override
    public int calcularCostoIVA() {
        return (int) (getPrecioUnitario() * getCantidad() * 1.12);
    }
    @Override
    public String toString() {
        return "ProductoFisico{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precioUnitario=" + getPrecioUnitario() +
                ", cantidad=" + getCantidad() +
                ", descripcion='" + descripcion + '\'' +
                ", presentacion='" + presentacion + '\'' +
                '}';
    }

}
