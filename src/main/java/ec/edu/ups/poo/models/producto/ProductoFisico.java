package ec.edu.ups.poo.models.producto;

public class ProductoFisico extends Producto {
    private String descripcion;
    private String presentacion;

    public ProductoFisico() {
    }

    public ProductoFisico(int id, String nombre, double precioUnitario, int cantidad, String descripcion, String presentacion) {
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
    
    
    
    @Override
    public String toString() {
        return "ProductoFisico{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precioUnitario=" + getPrecioUnitario() +
                ", cantidad=" + getCantidad() +
                ", descripcion='" + descripcion + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", costoConIVA=" + calcularCostoIVA() +  // Agregamos el costo con IVA
                '}';
    }
    
}