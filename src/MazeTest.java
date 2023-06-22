import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Tests for the Maze class to see that its methods are operating as they should
 */
public class MazeTest {


    /**
     * Tests the method isMovable() by creating a new maze with a string, and asserting
     * a whitespace position as movable.
     */
    @Test
    public void isMovableTest(){

        String test = "S **** **** G";
        Scanner scanner = new Scanner(test);
        Maze maze = new Maze(scanner);

        assertTrue(maze.isMovable(new Position(6,0)));

    }

    /**
     * Tests the method isMovable() by creating a new maze with a string
     * and asserting a wall '*' as not movable.
     */
    @Test
    public void isNotMovableTest(){

        String test = "*S****** ********* ***G*";
        Scanner scanner = new Scanner(test);
        Maze maze = new Maze(scanner);

        assertFalse(maze.isMovable(new Position(7,0)));

    }

    /**
     * Tests the method isGoal() by creating a new maze with a string and
     * asserting a position 'G' as the goal.
     */
    @Test
    public void isGoalTest() {
        String goalString = "S*** *** G";
        Scanner scanner = new Scanner(goalString);
        Maze maze = new Maze(scanner);

        assertTrue(maze.isGoal(new Position (9,0)));
    }

    /**
     * Tests the method isGoal() by creating a new maze with a string and
     * asserting a position that is not 'G' as not a goal.
     */
    @Test
    public void isNotGoalTest() {
        String goalString = "**G*    ***  **** ***   S ***  ";
        Scanner scanner = new Scanner(goalString);
        Maze maze = new Maze(scanner);

        assertFalse(maze.isGoal(new Position(4,0)));
    }

    /**
     * Tests the method getStartPosition() by creating a new maze with a string and
     * asserting the start position with a newly creating position with the same coordinates.
     */
    @Test
    public void getStartPositionTest() {
        String startString = "G* *S**";
        Scanner scanner = new Scanner(startString);
        Maze maze = new Maze(scanner);
        Position position = new Position(4,0);

        assertTrue(position.equals(maze.getStartPosition()));
    }

    /**
     * Tests exception by creating a new maze with a string
     * without a start position
     *
     */
    @Test (expected = ExceptionInInitializerError.class)
    public void noStartPositionTest() {
        String startString = "*****   **** G  ****";
        Scanner scanner = new Scanner(startString);
        Maze maze = new Maze(scanner);

    }

    /**
     * Tests exception by creating a new maze with a string
     * without a start position
     *
     */
    @Test (expected = ExceptionInInitializerError.class)
    public void noGoalPositionTest() {
        String startString = "*****   **** S  ****";
        Scanner scanner = new Scanner(startString);
        Maze maze = new Maze(scanner);

    }
}