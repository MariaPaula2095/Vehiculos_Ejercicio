public class Clientes {
    private String nombre;
    private int cedula;
    private String licencia;

    public Clientes(String nombre, int cedula, String licencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Cédula: " + cedula + " | Licencia: " + licencia;
    }
}
