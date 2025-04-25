package ec.edu.ups.poo.models;

public class Proveedor extends Persona {
    private String ruc;
    private String empresa;

    public Proveedor() {
    }

    public Proveedor(String cedula, String nombre, String ruc, String empresa) {
        super(cedula, nombre);
        this.ruc = ruc;
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String obtenerEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "cedula='" + getCedula() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", ruc='" + ruc + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
