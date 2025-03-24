public class Autos extends Vehiculos{

    //Atributos
    private int numeroPuertas;

    //Metodos

    public Autos(String marca, String modelo, int anio, double precioDia, boolean disponibilidad, int numeroPuertas) {
        super(marca, modelo, anio, precioDia, disponibilidad);
        this.numeroPuertas = numeroPuertas;
    }

    public Autos(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Número de Puertas: " + numeroPuertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("NUMERO DE PUERTAS DEL AUTO: " + numeroPuertas);
    }
}
