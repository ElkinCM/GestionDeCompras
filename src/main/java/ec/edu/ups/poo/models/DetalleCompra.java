package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.producto.Producto;

public class DetalleCompra {
    private int codigo;
    private int cantidad;
    private Producto producto;

    public DetalleCompra() {
    }

    public DetalleCompra(int codigo, int cantidad, Producto producto) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto = producto;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
