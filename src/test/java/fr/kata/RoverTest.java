package fr.kata;

import fr.kata.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
class RoverTest {

	private Rover rover;
	
	@BeforeEach
	public void setUp() {
         this.rover = new Rover();
	}
	
    @Test
    void setX() {
        assertEquals(10, rover.getX());
    }

    @Test
    void setY() {
        assertEquals(10, rover.getY());
    }

    @Test
    void setOrientation() {

        rover.setOrientation("NORTH");
        assertEquals("NORTH", rover.getOrientation());
    }

    @Test
    void process() {
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation("NORTH");

    	rover.process("LFFLFFF");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("NORTH", rover.getOrientation());
    }
    
    @Test
    void processWrongCommand() {
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation("NORTH");

    	rover.process("LFFLFFFZ");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("NORTH", rover.getOrientation());
    }

    @Test
    void boundaries() {
        rover.setX(2);
        rover.setY(3);
        rover.setOrientation("NORTH");

        rover.process("LFFFLFFFF");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("NORTH", rover.getOrientation());
    }
}