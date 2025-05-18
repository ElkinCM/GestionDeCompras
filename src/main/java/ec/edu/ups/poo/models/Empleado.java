package ec.edu.ups.poo.models;

public class Empleado extends Persona {
    private String cargo;
    private double salario;
    private Departamento departamento;

    public Empleado(String cedula, String nombre, String cargo, double salario, Departamento departamento) {
        super(cedula, nombre);
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado() {
        super("", "");
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "\n========= EMPLEADO =========\n" +
            "Cédula        : " + getCedula() + "\n" +
            "Nombre        : " + getNombre() + "\n" +
            "Cargo         : " + cargo + "\n" +
            "Salario       : $" + salario + "\n" +
            "Departamento  : " + (departamento != null ? departamento.getNombreDp() : "No asignado") + "\n" +
            "=============================\n";
    }
}
