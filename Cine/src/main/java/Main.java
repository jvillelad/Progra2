import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio de la entrada: ");
        double precioEntrada = scanner.nextDouble();

        Cine cine = new Cine(8, 9, precioEntrada);

        System.out.print("Ingrese el título de la película: ");
        String tituloPelicula = scanner.next();
        System.out.print("Ingrese la duración de la película (en minutos): ");
        int duracionPelicula = scanner.nextInt();
        System.out.print("Ingrese la edad mínima para la película: ");
        int edadMinimaPelicula = scanner.nextInt();
        System.out.print("Ingrese el nombre del director de la película: ");
        String directorPelicula = scanner.next();

        Pelicula pelicula = new Pelicula(tituloPelicula, duracionPelicula, edadMinimaPelicula, directorPelicula);
        cine.reproducirPelicula(pelicula);

        System.out.print("Ingrese el nombre del espectador: ");
        String nombreEspectador = scanner.next();
        System.out.print("Ingrese la edad del espectador: ");
        int edadEspectador = scanner.nextInt();
        System.out.print("Ingrese el dinero que tiene el espectador: ");
        double dineroEspectador = scanner.nextDouble();

        Espectador espectador = new Espectador(nombreEspectador, edadEspectador, dineroEspectador);

        System.out.print("Ingrese la fila del asiento (A-H): ");
        char filaAsiento = scanner.next().charAt(0);
        System.out.print("Ingrese el número de columna del asiento (1-9): ");
        int columnaAsiento = scanner.nextInt();

        if (cine.comprarEntrada(espectador, filaAsiento, columnaAsiento)) {
            System.out.println(espectador.getNombre() + " compró una entrada para " + pelicula.getTitulo());
        } else {
            System.out.println(espectador.getNombre() + " no pudo comprar una entrada.");
        }

        scanner.close();
    }
}

class Cine {
    private Pelicula peliculaEnReproduccion;
    private double precioEntrada;
    private Asiento[][] asientos;

    public Cine(int filas, int columnas, double precioEntrada) {
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[filas][columnas];
        // Inicializar asientos
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                asientos[fila][columna] = new Asiento((char)('A' + columna), fila + 1);
            }
        }
    }

    public void reproducirPelicula(Pelicula pelicula) {
        peliculaEnReproduccion = pelicula;
    }

    public boolean comprarEntrada(Espectador espectador, char fila, int columna) {
        int filaIndex = fila - 'A';
        if (filaIndex >= 0 && filaIndex < asientos.length && columna >= 1 && columna <= asientos[0].length) {
            Asiento asiento = asientos[filaIndex][columna - 1];
            if (!asiento.estaOcupado() && espectador.getDinero() >= precioEntrada && espectador.getEdad() >= peliculaEnReproduccion.getEdadMinima()) {
                asiento.ocupar();
                espectador.pagarEntrada(precioEntrada);
                return true;
            }
        }
        return false;
    }
}

class Pelicula {
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;

    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    String getTitulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Espectador {
    private String nombre;
    private int edad;
    private double dinero;

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    public int getEdad() {
        return edad;
    }

    public void pagarEntrada(double precio) {
        dinero -= precio;
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Asiento {
    private char letraFila;
    private int numeroFila;
    private boolean ocupado;

    public Asiento(char letraFila, int numeroFila) {
        this.letraFila = letraFila;
        this.numeroFila = numeroFila;
        this.ocupado = false;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }
}
