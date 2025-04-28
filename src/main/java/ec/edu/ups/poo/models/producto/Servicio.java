package ec.edu.ups.poo.models.producto;

import ec.edu.ups.poo.models.Proveedor;
import java.util.List;

public class Servicio extends Producto {
    private String tipo;
    private String categoria;

    public Servicio() {
    }

    public Servicio(int id, String nombre, int precioUnitario, int cantidad, List<Proveedor> proveedores, String tipo, String categoria) {
        super(id, nombre, precioUnitario, cantidad);
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
        return "\n========= SERVICIO =========\n" +
                "ID            : " + getId() + "\n" +
                "Nombre        : " + getNombre() + "\n" +
                "Precio Unit.  : $" + String.format("%.2f", getPrecioUnitario()) + "\n" +
                "Cantidad      : " + getCantidad() + "\n" +
                "Tipo          : " + tipo + "\n" +
                "Categoría     : " + categoria + "\n" +
                "=============================\n";
    }
    

}
