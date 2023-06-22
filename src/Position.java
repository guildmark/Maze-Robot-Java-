
import java.util.Objects;

/**
 * Position with x- and y- coordinates.
 */
public class Position {
    private int x;
    private int y;


    /**
     * Creates a a position with new x- and y- coordinates.
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @return value of the x-coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return value of the y-coordinate.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Creates a new position south of the current position.
     * @return the new position.
     */
    public Position getPosToSouth() {
        Position pos = new Position(this.x, this.y+1);
        return pos;
    }

    /**
     * Creates a new position north of the current position.
     * @return the new position.
     */
    public Position getPosToNorth() {
        Position pos = new Position(this.x, this.y-1);
        return pos;
    }

    /**
     * Creates a new position west of the current position.
     * @return the new position.
     */
    public Position getPosToWest() {
        Position pos = new Position(this.x-1, this.y);
        return pos;
    }

    /**
     * Creates a new position easet of the current position.
     * @return the new position.
     */
    public Position getPosToEast() {
        Position pos = new Position(this.x+1,this.y);
        return pos;
    }

    /**
     * Checks to see if an object is equal to the position.
     * @param obj
     * @return true if it equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Position)) {
            return false;
        }
        return Integer.compare(this.x, ((Position) obj).x) == 0 && Integer.compare(this.y, ((Position) obj).y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
