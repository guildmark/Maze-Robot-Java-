import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    /**
     * Tests the method getX(), by creating a new position and
     * asserting the correct x-value.
     */
    @Test
    public void getXtest(){
        Position pos = new Position(5,6);
        assertEquals(5, pos.getX());
    }

    /**
     * Tests the method getY(), by creating a new position and
     * asserting the correct y-value.
     */
    @Test
    public void getYtest() {
        Position pos = new Position(2,4);
        assertEquals(4, pos.getY());
    }

    /**
     * Tests the method getPosSouth() by creating a new position
     * and asserting the correct south value of the position.
     */
    @Test
    public void getPosSouthTest() {
        Position pos = new Position(5,5);
        pos = pos.getPosToSouth();
        assertEquals(6, pos.getY());
    }

    /**
     * Tests the method getPosNorth() by creating a new position
     * and asserting the correct north value of the position.
     */
    @Test
    public void getPosNorthTest() {
        Position pos = new Position(3, 5);
        pos = pos.getPosToNorth();
        assertEquals(4,pos.getY());
    }

    /**
     * Tests the method getPosWest() by creating a new position
     * and asserting the correct west value of the position.
     */
    @Test
    public void getPosWestTest() {
        Position pos = new Position( 10, 12);
        pos = pos.getPosToWest();
        assertEquals(9, pos.getX());
    }

    /**
     * Tests the method getPosWest() by creating a new position and
     * asserting the correct east value of the position.
     */
    @Test
    public void getPosEastTest() {
        Position pos = new Position(15,12);
        pos = pos.getPosToEast();
        assertEquals(16, pos.getX());
    }

    /**
     * Tests the method equals() by creating two positions with the
     * same coordinates and checking to see that they are equal.
     */
    @Test
    public void equalsTest() {
        Position pos1 = new Position(5,10);
        Position pos2 = new Position(5,10);
        assertTrue(pos1.equals(pos2));
    }

    /**
     * Tests the method equals() by creating two positions with
     * different coordinates and checks to see that they are not equal.
     */
    @Test
    public void notEqualsTest() {
        Position pos1 = new Position(3,12);
        Position pos2 = new Position(6,30);
        assertFalse(pos1.equals(pos2));
    }
}