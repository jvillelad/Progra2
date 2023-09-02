import vehiculos.*;

public class Main {
    public static void main(String[] args) {
        Automovil automovil = new Automovil("Automovil1", 4);
        Bicicleta bicicleta = new Bicicleta("Bicicleta1");

        automovil.acelerar(80);
        automovil.frenar();

        bicicleta.acelerar(20);
        bicicleta.frenar();
    }
}
