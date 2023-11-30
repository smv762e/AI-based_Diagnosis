package com.backend_robots.backend_robot.model;

public class Test {

    public static void main(String[] args) {
    
        //Test Admin

        Admin admin = new Admin(1, "user", "password");

        System.out.println(admin);

        admin.setId(2);
        admin.setUser("user2");
        admin.setPassword("password2");

        System.out.println(admin);

        //Test Place && Routes

        Place enfermeria = new Place(1, 1, "Enfermeria");
        Place quirofano = new Place(2, 2, "Quirofano");

        Routes route = new Routes(1, enfermeria, quirofano);

        System.out.println(route);

        //Test Record

        
    }

}
