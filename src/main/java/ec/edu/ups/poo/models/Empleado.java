package ec.edu.ups.poo.models;

public class Empleado extends Persona {

    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(String cedula, String nombre, Departamento departamento) {
        super(cedula, nombre);
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
                "cedula='" + getCedula() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
