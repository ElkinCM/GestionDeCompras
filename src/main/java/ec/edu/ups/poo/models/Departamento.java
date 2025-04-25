package ec.edu.ups.poo.models;

public class Departamento {
    private String nombreDp;
    private String descripcion;
    private String presupuesto;

    public Departamento() {
    }

    public Departamento(String nombreDp, String descripcion, String presupuesto) {
        this.nombreDp = nombreDp;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
    }

    public String getNombreDp() {
        return nombreDp;
    }

    public void setNombreDp(String nombreDp) {
        this.nombreDp = nombreDp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }
}
