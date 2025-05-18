package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.producto.Producto;
import ec.edu.ups.poo.models.producto.ProductoFisico;

public class DetalleCompra {
    private Producto producto;
    private int cantidad;

    public DetalleCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    public double calcularIVA() {
        return calcularSubtotal() * 0.12;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Cantidad: ").append(cantidad).append("\n");
    sb.append("Producto: ").append(producto.getNombre()).append("\n");
    sb.append("Precio Unitario: $").append(producto.getPrecioUnitario()).append("\n");
    sb.append("Subtotal: $").append(calcularTotal()).append("\n");

    if (producto instanceof ProductoFisico) {
        sb.append("Tipo: Producto Físico\n");
    } else {
        sb.append("Tipo: Servicio\n");
    }

    return sb.toString();
}

}
