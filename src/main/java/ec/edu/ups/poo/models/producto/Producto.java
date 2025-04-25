package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;
import ec.edu.ups.poo.models.interfaces.Calculable;

import java.util.List;
import java.util.Objects;

public abstract class Producto implements Calculable {
    private int id;
    private String nombre;
    private int precioUnitario;
    private int cantidad;
    private List<Proveedor> proveedores;

    public Producto() {
    }

    public Producto(int id, String nombre, int precioUnitario, int cantidad, List<Proveedor> proveedores) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.proveedores = proveedores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                ", proveedores=" + proveedores +
                '}';
    }

}
