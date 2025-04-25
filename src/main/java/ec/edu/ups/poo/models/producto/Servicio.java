package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;
import java.util.List;

public class Servicio extends Producto {
    private String tipo;
    private String categoria;

    public Servicio() {
    }

    public Servicio(int id, String nombre, int precioUnitario, int cantidad, List<Proveedor> proveedores, String tipo, String categoria) {
        super(id, nombre, precioUnitario, cantidad, proveedores);
        this.tipo = tipo;
        this.categoria = categoria;
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
    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precioUnitario=" + getPrecioUnitario() +
                ", cantidad=" + getCantidad() +
                ", proveedores=" + getProveedores() +
                ", tipo='" + tipo + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

}
