package fr.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

        rover.setOrientation(Orientation.NORTH);
        assertEquals(Orientation.NORTH, rover.getOrientation());
    }

    @Test
    void processStepByStepRight() {
    	
    	int posX = 2;
    	int posY = 3;
    	
    	rover.setX(posX);
    	rover.setY(posY);
    	rover.setOrientation(Orientation.NORTH);

    	rover.process("LF");
    	posX--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.WEST, rover.getOrientation());
        
    	rover.process("LF");
    	posY--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.SOUTH, rover.getOrientation());
        
    	rover.process("LF");
    	posX++;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.EAST, rover.getOrientation());
        
        rover.process("LF");
        posY++;
        
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.NORTH, rover.getOrientation());
        
    }
    
    @Test
    void processStepByStepLeft() {
    	
    	int posX = 2;
    	int posY = 3;
    	
    	rover.setX(posX);
    	rover.setY(posY);
    	rover.setOrientation(Orientation.NORTH);

       	rover.process("RF");
       	posX++;
       	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.EAST, rover.getOrientation());
        
    	rover.process("RF");
    	posY--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.SOUTH, rover.getOrientation());
        
    	rover.process("RF");
    	posX--;
    	
        assertEquals(posX, rover.getX());
        assertEquals(posY, rover.getY());
        assertEquals(Orientation.WEST, rover.getOrientation());
        
        rover.process("RF");

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals(Orientation.NORTH, rover.getOrientation());
        
    }
    
    @Test
    void process() {
    	
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation(Orientation.NORTH);

    	rover.process("LFFLFFF");

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Orientation.SOUTH, rover.getOrientation());
    }
    
    @Test
    void processSouth() {
    	
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation(Orientation.SOUTH);

    	rover.process("LFFLFFF");

        assertEquals(4, rover.getX());
        assertEquals(6, rover.getY());
        assertEquals(Orientation.NORTH, rover.getOrientation());
    }
    
    @Test
    void processEast() {
    	
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation(Orientation.EAST);

    	rover.process("LFFLFFF");

        assertEquals(0, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals(Orientation.WEST, rover.getOrientation());
    }
    
    @Test
    void processWest() {
    	
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation(Orientation.WEST);

    	rover.process("LFFLFFF");

        assertEquals(5, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals(Orientation.EAST, rover.getOrientation());
    }
    
    @Test
    void processWrongCommand() {
    	rover.setX(2);
    	rover.setY(3);
    	rover.setOrientation(Orientation.NORTH);

    	rover.process("LFFLFFFZ");

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Orientation.SOUTH, rover.getOrientation());
    }

    @Test
    void boundaries() {
        rover.setX(2);
        rover.setY(3);
        rover.setOrientation(Orientation.NORTH);

        rover.process("LFFFLFFFF");

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Orientation.SOUTH, rover.getOrientation());
    }
}