package com.mycompany.main;


import java.util.ArrayList;

class Catedratico {
    private static int contadorCatedraticos = 0;
    private int numeroCatedratico;
    private String nombre;

    public Catedratico(String nombre) {
        this.nombre = nombre;
        this.numeroCatedratico = ++contadorCatedraticos;
    }

    public void imprimirDatos() {
        System.out.println("Catedrático #" + numeroCatedratico);
        System.out.println("Nombre: " + nombre);
    }
}

class Alumno {
    private static int contadorAlumnos = 0;
    private int carnet;
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.carnet = ++contadorAlumnos;
    }

    public void imprimirDatos() {
        System.out.println("Alumno #" + carnet);
        System.out.println("Nombre: " + nombre);
    }
}

class Curso {
    private String nombre;
    private int espacioMaximo;
    private int alumnosInscritos;

    public Curso(String nombre, int espacioMaximo) {
        this.nombre = nombre;
        this.espacioMaximo = espacioMaximo;
        this.alumnosInscritos = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean verificaEspacio() {
        return alumnosInscritos < espacioMaximo;
    }

    public void inscribirAlumno() {
        if (verificaEspacio()) {
            alumnosInscritos++;
        } else {
            System.out.println("El curso " + nombre + " está lleno.");
        }
    }
}

class Asignacion {
    private Alumno alumno;
    private ArrayList<Curso> cursosAsignados;

    public Asignacion(Alumno alumno) {
        this.alumno = alumno;
        cursosAsignados = new ArrayList<>();
    }

    public void addCurso(Curso curso) {
        if (cursosAsignados.size() < 3) {
            cursosAsignados.add(curso);
            curso.inscribirAlumno();
        } else {
            System.out.println("El alumno ya tiene asignados 3 cursos.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Catedratico catedratico1 = new Catedratico("Catedrático 1");
        Catedratico catedratico2 = new Catedratico("Catedrático 2");
        Catedratico catedratico3 = new Catedratico("Catedrático 3");

        Curso curso1 = new Curso("Curso 1", 2);
        Curso curso2 = new Curso("Curso 2", 5);
        Curso curso3 = new Curso("Curso 3", 5);

        Alumno alumno1 = new Alumno("Alumno 1");
        Alumno alumno2 = new Alumno("Alumno 2");
        Alumno alumno3 = new Alumno("Alumno 3");

        Asignacion asignacion1 = new Asignacion(alumno1);
        Asignacion asignacion2 = new Asignacion(alumno2);
        Asignacion asignacion3 = new Asignacion(alumno3);

        asignacion1.addCurso(curso1);
        asignacion1.addCurso(curso2);
        asignacion1.addCurso(curso3);

        asignacion2.addCurso(curso2);
        asignacion2.addCurso(curso3);

        asignacion3.addCurso(curso1);
        asignacion3.addCurso(curso2);
    }
}
