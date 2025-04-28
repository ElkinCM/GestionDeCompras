package ec.edu.ups.poo.models;

import ec.edu.ups.poo.models.enums.EstadoSolicitud;
import ec.edu.ups.poo.models.producto.ProductoFisico;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private static int contador = 1;
    private int id;
    private String solicitante;
    private Departamento departamento;
    private EstadoSolicitud estado;
    private List<DetalleCompra> detalles;
    private List<ProductoFisico> productos = new ArrayList<>();


    public SolicitudCompra() {
        this.id = contador++;
        this.solicitante = null;
        this.departamento = null;
        this.estado = EstadoSolicitud.SOLICITADA;
        this.detalles = new ArrayList<>();
    }
    public SolicitudCompra(String solicitante, Departamento departamento) {
        this.id = contador++;
        this.solicitante = solicitante;
        this.departamento = departamento;
        this.estado = EstadoSolicitud.SOLICITADA;
        this.detalles = new ArrayList<>();
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolicitante() {
        return solicitante;
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

    public EstadoSolicitud getEstadoSolicitud() {
        return this.estado;
    }

    // Método para calcular el total de la solicitud
    public double calcularTotal() {
        return detalles.stream().mapToDouble(DetalleCompra::calcularTotal).sum();
    }


    //Ordenamiento
    public void sortByIdInsertion(ArrayList<SolicitudCompra> solicitudes) {
        for (int i = 1; i < solicitudes.size(); i++) {
            SolicitudCompra key = solicitudes.get(i);
            int j = i - 1;
            while (j >= 0 && solicitudes.get(j).getId() > key.getId()) {
                solicitudes.set(j + 1, solicitudes.get(j));
                j = j - 1;
            }
            solicitudes.set(j + 1, key);
        }
    }
    public int searchById(ArrayList<SolicitudCompra> solicitudes, int id) {
        int bajo = 0;
        int alto = solicitudes.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (solicitudes.get(medio).getId() == id) {
                return medio; 
            } else if (solicitudes.get(medio).getId() < id) {
                bajo = medio + 1; 
            } else {
                alto = medio - 1; 
            }
        }return -1; 
    }

    @Override
    public String toString() {
        return "\n====== SOLICITUD DE COMPRA ======\n" +
            "ID           : " + id + "\n" +
            "Solicitante  : " + solicitante + "\n" +
            "Departamento : " + departamento.getNombreDp() + "\n" +
            "Estado       : " + estado + "\n" + 
            "Productos:\n" + listarProductosSolicitados() +
            "=================================\n";
    }

    private String listarProductosSolicitados() {
        StringBuilder sb = new StringBuilder();
        for (ProductoFisico producto : productos) {
            sb.append(" - ").append(producto.getNombre())
            .append(" | Cantidad: ").append(producto.getCantidad())
            .append("\n");
        }
        return sb.toString();
    }
}
