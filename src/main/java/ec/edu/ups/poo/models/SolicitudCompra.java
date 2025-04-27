package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.enums.DepartamentoEnum;
import ec.edu.ups.poo.models.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private static int contador = 1; // Contador estático para generar los IDs automáticamente
    private int id;
    private String solicitante;
    private DepartamentoEnum departamento;
    private EstadoSolicitud estado;
    private List<DetalleCompra> detalles;

    public SolicitudCompra(String solicitante, DepartamentoEnum departamento) {
        this.id = contador++; // Asigna un ID único automáticamente
        this.solicitante = solicitante;
        this.departamento = departamento;
        this.estado = EstadoSolicitud.SOLICITADA;
        this.detalles = new ArrayList<>();
    }

    // Getter para el ID
    public int getId() {
        return id;
    }

    // Método para cambiar el ID 
    public void setId(int id) {
        this.id = id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public DepartamentoEnum getDepartamento() {
        return departamento;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return this.estado;
    }

    public double calcularTotal() {
        return detalles.stream().mapToDouble(DetalleCompra::calcularTotal).sum();
    }
}
