package vehiculos;

public class Automovil extends Vehiculo {
    private int pasajeros;

    public Automovil(String nombre, int pasajeros) {
        super(nombre);
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    @Override
    public void acelerar(int velocidad) {
        System.out.println(getNombre() + " está acelerando a " + velocidad + " km/h");
    }

    @Override
    public void frenar() {
        System.out.println(getNombre() + " está frenando");
    }
}