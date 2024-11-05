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
    	rover.setX(10);
        assertEquals(10, rover.getX());
    }

    @Test
    void setY() {
    	rover.setY(10);
        assertEquals(10, rover.getY());
    }

    @Test
    void setOrientation() {

        rover.setOrientation("NORTH");
        assertEquals("NORTH", rover.getOrientation());
    }

    @Test
    void processStepByStepRight() {
    	
    	int posX = 2;
    	int posY = 3;
    	
    	rover.setX(posX);
    	rover.setY(posY);
    	rover.setOrientation("NORTH");

    	rover.process("LF");
    	posX--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals("WEST", rover.getOrientation());
        
    	rover.process("LF");
    	posY--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals("SOUTH", rover.getOrientation());
        
    	rover.process("LF");
    	posX++;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals("EAST", rover.getOrientation());
        
        rover.process("LF");
        posY++;
        
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals("NORTH", rover.getOrientation());
        
    }
    
    @Test
    void processStepByStepLeft() {
    	
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation("NORTH");

       	rover.process("RF");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("EAST", rover.getOrientation());
        
    	rover.process("RF");
        
        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("SOUTH", rover.getOrientation());
        
    	rover.process("RF");
        
        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("WEST", rover.getOrientation());
        
        rover.process("RF");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
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
        assertEquals("SOUTH", rover.getOrientation());
    }
    
    @Test
    void processWrongCommand() {
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation("NORTH");

    	rover.process("LFFLFFFZ");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("SOUTH", rover.getOrientation());
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