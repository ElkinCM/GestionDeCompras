package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.producto.Producto;

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

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
}
