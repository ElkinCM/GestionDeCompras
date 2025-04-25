package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.enums.EstadoSolicitud;
import ec.edu.ups.poo.models.interfaces.Calculable;

import java.util.List;

public class SolicitudCompra {
    private int id;
    private String departamento;
    private EstadoSolicitud estado;
    private List<Calculable> items;

    public SolicitudCompra() {
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public SolicitudCompra(int id, String departamento, EstadoSolicitud estado, List<Calculable> items) {
        this.id = id;
        this.departamento = departamento;
        this.estado = estado;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public List<Calculable> getItems() {
        return items;
    }

    public void setItems(List<Calculable> items) {
        this.items = items;
    }

    // Método que suma el costo con IVA de todos los productos
    public double calcularTotal() {
        double total = 0;
        if (items != null) {
            for (Calculable item : items) {
                total += item.calcularCostoIVA();
            }
        }
        return total;
    }

    // Métodos para cambiar el estado de la solicitud
    public void aprobar() {
        this.estado = EstadoSolicitud.APROBADA;
    }

    public void rechazar() {
        this.estado = EstadoSolicitud.RECHAZADA;
    }

    public void revisar() {
        this.estado = EstadoSolicitud.EN_REVISION;
    }

    public void solicitar() {
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    @Override
    public String toString() {
        return "SolicitudCompra{" +
                "id=" + id +
                ", departamento='" + departamento + '\'' +
                ", estado=" + estado +
                ", totalConIVA=" + calcularTotal() +
                '}';
    }
}
