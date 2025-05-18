package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.enums.EstadoSolicitud;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private static int contador = 1;
    private int id;
    private Empleado solicitante; // ← Cambiado de String a Empleado
    private Departamento departamento;
    private EstadoSolicitud estado;
    private List<DetalleCompra> detalles = new ArrayList<>();

    public SolicitudCompra() {
        this.id = contador++;
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public SolicitudCompra(Empleado solicitante, Departamento departamento) {
        this.id = contador++;
        this.solicitante = solicitante;
        this.departamento = departamento;
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public Departamento getDepartamento() {
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

    public double calcularTotal() {
        return detalles.stream().mapToDouble(DetalleCompra::calcularTotal).sum();
    }

    public void sortByIdInsertion(List<SolicitudCompra> solicitudes) {
        for (int i = 1; i < solicitudes.size(); i++) {
            SolicitudCompra key = solicitudes.get(i);
            int j = i - 1;
            while (j >= 0 && solicitudes.get(j).getId() > key.getId()) {
                solicitudes.set(j + 1, solicitudes.get(j));
                j--;
            }
            solicitudes.set(j + 1, key);
        }
    }

    public int searchById(List<SolicitudCompra> solicitudes, int id) {
        int bajo = 0, alto = solicitudes.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (solicitudes.get(medio).getId() == id) return medio;
            if (solicitudes.get(medio).getId() < id) bajo = medio + 1;
            else alto = medio - 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n====== SOLICITUD DE COMPRA ======\n");
        sb.append("ID           : ").append(id).append("\n");
        sb.append("Solicitante  : ").append(solicitante != null ? solicitante.getNombre() : "No asignado").append("\n");
        sb.append("Departamento : ").append(departamento != null ? departamento.getNombreDp() : "N/A").append("\n");
        sb.append("Estado       : ").append(estado).append("\n");

        if (detalles.isEmpty()) {
            sb.append(">>> No hay productos agregados.\n");
        } else {
            sb.append(">>> Detalles de Productos:\n");
            for (DetalleCompra detalle : detalles) {
                sb.append("-----------------------------\n");
                sb.append(detalle.toString());
            }
            sb.append("-----------------------------\n");
            sb.append("Subtotal     : $").append(String.format("%.2f", calcularTotal() / 1.12)).append("\n");
            sb.append("IVA (12%)    : $").append(String.format("%.2f", calcularTotal() - (calcularTotal() / 1.12))).append("\n");
            sb.append("TOTAL        : $").append(String.format("%.2f", calcularTotal())).append("\n");
        }

        sb.append("=================================\n");
        return sb.toString();
    }
}
