package ec.edu.ups.poo.models;

public class Empleado {

    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "departamento=" + departamento +
                '}';
    }
}
