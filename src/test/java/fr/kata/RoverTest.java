package fr.kata;

import fr.kata.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RoverTest {

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }

    @Test
    void setOrientation() {
        Rover rover = new Rover();
        rover.setOrientation("NORTH");
        assertEquals("NORTH", rover.getOrientation());
    }

    @Test
    void process() {
        var r = new Rover();
        r.setX(2);
        r.setY(3);
        r.setOrientation("NORTH");

        r.process("LFFLFFF");

        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
        assertEquals("SOUTH", r.getOrientation());
    }

    @Test
    void boundaries() {
        var r = new Rover();
        r.setX(2);
        r.setY(3);
        r.setOrientation("NORTH");

        r.process("LFFFLFFFF");

        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
        assertEquals("SOUTH", r.getOrientation());
    }
}