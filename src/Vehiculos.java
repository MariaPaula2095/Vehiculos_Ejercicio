public class Vehiculos {

    // Atributos Clase Padre
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precioDia;
    protected boolean disponibilidad;

    //Metodos
    public Vehiculos() {
    }

    public Vehiculos(String marca, String modelo, int anio, double precioDia, boolean disponibilidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDia = precioDia;
        this.disponibilidad = disponibilidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioDia=" + precioDia +
                ", disponibilidad=" + disponibilidad +
                '}';
    }

    //Metodos propios
    public void mostrarInfo() {
        System.out.println("LA MARCA ES: " + marca);
        System.out.println("El MODELO ES: " + modelo);
        System.out.println("EL AÑO ES: " + anio);
        System.out.println("El PRECIO BASE ES: " + precioDia);
        System.out.println("DISPONIBILIDAD: " + disponibilidad);
    }

}
