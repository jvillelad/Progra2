package vehiculos;

public class Bicicleta extends Vehiculo {
    public Bicicleta(String nombre) {
        super(nombre);
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