import java.util.ArrayList;
import java.util.Scanner;

public class Alquiler {
    private ArrayList<Vehiculos> vehiculos;
    private ArrayList<Clientes> clientes;
    private Scanner teclado;
    private boolean estado;

    public Alquiler() {
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        teclado = new Scanner(System.in);
        estado = true;
    }

    public void registrarVehiculo() {
        System.out.println("Ingrese la marca del vehículo: ");
        String marca = teclado.nextLine();
        System.out.println("Ingrese el modelo del vehículo: ");
        String modelo = teclado.nextLine();
        System.out.println("Ingrese el año del vehículo: ");
        int anio = teclado.nextInt();
        System.out.println("Ingrese el precio por día: ");
        double precioDia = teclado.nextDouble();
        teclado.nextLine();

        Vehiculos v = new Vehiculos(marca, modelo, anio, precioDia, true);
        vehiculos.add(v);
        System.out.println("Vehículo registrado con éxito.");
    }

    public void registrarCliente() {
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la cédula del cliente: ");
        int cedula = teclado.nextInt();
        teclado.nextLine(); // Consumir salto de línea
        System.out.println("Ingrese el número de licencia: ");
        String licencia = teclado.nextLine();

        Clientes c = new Clientes(nombre, cedula, licencia);
        clientes.add(c);
        System.out.println("Cliente registrado con éxito.");
    }

    public void alquilarVehiculo() {
        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCliente = teclado.nextLine();
        Clientes cliente = buscarCliente(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese el modelo del vehículo a alquilar: ");
        String modeloVehiculo = teclado.nextLine();
        Vehiculos vehiculo = buscarVehiculo(modeloVehiculo);

        if (vehiculo == null || !vehiculo.isDisponibilidad()) {
            System.out.println("Vehículo no disponible.");
            return;
        }

        System.out.println("Ingrese la cantidad de días: ");
        int dias = teclado.nextInt();
        teclado.nextLine(); // Consumir salto de línea

        double costo = calcularCosto(vehiculo.getPrecioDia(), dias);
        vehiculo.setDisponibilidad(false);
        System.out.println("Alquiler exitoso. Costo total: $" + costo);
    }

    private double calcularCosto(double precioDia, int dias) {
        double total = precioDia * dias;
        if (dias > 7) {
            total *= 0.9; // Aplicar 10% de descuento
        }
        return total;
    }

    public void mostrarVehiculosDisponibles() {
        System.out.println("Vehículos disponibles:");
        for (Vehiculos v : vehiculos) {
            if (v.isDisponibilidad()) {
                System.out.println(v);
            }
        }
    }

    public void devolverVehiculo() {
        System.out.println("Ingrese el modelo del vehículo a devolver: ");
        String modelo = teclado.nextLine();

        Vehiculos vehiculo = buscarVehiculo(modelo);
        if (vehiculo == null || vehiculo.isDisponibilidad()) {
            System.out.println("El vehículo no está en alquiler o no existe.");
            return;
        }

        vehiculo.setDisponibilidad(true);
        System.out.println("Vehículo devuelto con éxito.");
    }

    private Clientes buscarCliente(String nombre) {
        for (Clientes c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    private Vehiculos buscarVehiculo(String modelo) {
        for (Vehiculos v : vehiculos) {
            if (v.getModelo().equalsIgnoreCase(modelo)) {
                return v;
            }
        }
        return null;
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("""
              --- Menú Empresa de Alquiler ---
               1. Registrar Vehículo
               2. Registrar Cliente
               3. Alquilar Vehículo
               4. Mostrar Vehículos Disponibles
               5. Devolver Vehículo
               6. Salir
              """);
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> registrarVehiculo();
                case 2 -> registrarCliente();
                case 3 -> alquilarVehiculo();
                case 4 -> mostrarVehiculosDisponibles();
                case 5 -> devolverVehiculo();
                case 6 -> {
                    System.out.println("Salir");
                    estado = false;
                }
                default -> System.out.println("Opción invalida");
            }
        } while (estado);
    }

    public static void main(String[] args) {
        Alquiler alquiler = new Alquiler();
        alquiler.menu();
    }
}
