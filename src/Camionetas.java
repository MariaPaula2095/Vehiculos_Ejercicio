public class Camionetas extends Vehiculos{
    //Atributos
    private String Capacidad;

    //Metodos
    public Camionetas(String marca, String modelo, int anio, double precioDia, boolean disponibilidad, String capacidad) {
        super(marca, modelo, anio, precioDia, disponibilidad);
        Capacidad = capacidad;
    }

    public Camionetas(String capacidad) {
        Capacidad = capacidad;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Capacidad='" + Capacidad + '\'' +
                '}';
    }

    //Metodos propios
    @Override
    public void mostrarInfo (){
        super.mostrarInfo();
        System.out.println("CAPACIDAD DE LA CAMIONETA (Kg): " + Capacidad);
    }
}
