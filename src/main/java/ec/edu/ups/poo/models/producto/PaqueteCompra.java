package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;
import java.util.List;

public class PaqueteCompra extends Producto {
    private String peso;

    public PaqueteCompra() {
    }

    public PaqueteCompra(int id, String nombre, int precioUnitario, int cantidad, List<Proveedor> proveedores, String peso) {
        super(id, nombre, precioUnitario, cantidad, proveedores);
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public double calcularPesoTotal() {
        // Ejemplo: si el peso es "5.5", convertir a double
        try {
            return Double.parseDouble(peso) * getCantidad();
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @Override
    public int calcularCostoIVA() {
        return (int) (getPrecioUnitario() * getCantidad() * 1.12);
    }
    @Override
    public String toString() {
        return "PaqueteCompra{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precioUnitario=" + getPrecioUnitario() +
                ", cantidad=" + getCantidad() +
                ", proveedores=" + getProveedores() +
                ", peso='" + peso + '\'' +
                ", pesoTotal=" + calcularPesoTotal() +
                '}';
    }

}
