package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.interfaces.Calculable;

public abstract class Producto implements Calculable {
    private int id;
    private String nombre;
    private double precioUnitario;
    private int cantidad;

    public Producto(int id, String nombre, double precioUnitario, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }
    public Producto() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }
}
