package fr.kata;

public class Main {
    public static void main(String[] args) {
        var r = new Rover();
        r.setX(2);
        r.setY(3);
        r.setOrientation("NORTH");

        r.process("LFFLFFF");

        System.out.println("Rover X: " + r.getX());
        System.out.println("Rover Y: " + r.getY());
        System.out.println("Rover Orientation: " + r.getOrientation());
    }
}