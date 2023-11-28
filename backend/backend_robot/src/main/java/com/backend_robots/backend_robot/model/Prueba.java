package com.backend_robots.backend_robot.model;

public class Prueba {

    public static void main(String[] args) {

        Place enfermeria = new Place(1, 1, "Enfermeria");
        Place quirofano = new Place(2, 2, "Quirofano");

        Rutas ruta = new Rutas(1, enfermeria, quirofano);

        System.out.println(ruta);

    }

}
