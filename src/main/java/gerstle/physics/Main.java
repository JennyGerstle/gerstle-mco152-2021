package gerstle.physics;

public class Main{

    public static void main(String[] args){
        Rocket rocket = new Rocket(71, 35);

        System.out.println(rocket.getX(3));
        System.out.println(rocket.getY(3));
        System.out.println(rocket.getFlightTime());

    }

}


