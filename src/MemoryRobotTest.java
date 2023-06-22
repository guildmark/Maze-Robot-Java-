import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MemoryRobotTest {

    @Test
    public void getStartPositionTest() throws FileNotFoundException {
        File file = new File("C:\\Users\\MK02\\IdeaProjects\\ou2real\\src\\mazetest.txt");
        Scanner scanner = new Scanner(file);
        Maze maze = new Maze(scanner);
        Position position = maze.getStartPosition();

        MemoryRobot memRobot = new MemoryRobot(maze);

        assertTrue(position.equals(memRobot.getCurrentPosition()));


    }

}