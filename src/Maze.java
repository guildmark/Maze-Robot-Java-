import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * A maze consisting of a start position, goal position, walls and movable spots.
 */
public class Maze {

    private List<String> mazeData = new ArrayList<String>();


    /**
     * Creates a maze from a text file by adding it, string by string, to an arraylist.
     * @param input
     * @throws ExceptionInInitializerError if the maze does not contain either start or goal positions.
     */
    public Maze(Scanner input) throws ExceptionInInitializerError {

        int startValid = 0;
        int goalValid = 0;

        String line;

        while(input.hasNextLine()) {

            line = input.nextLine();
            mazeData.add(line);
        }

        //Confirm that the maze is valid with both a start and goal position.

        for(int i = 0; i < mazeData.size(); i++) {
            String checkMaze = mazeData.get(i);
            if(checkMaze.contains("S")) {
                startValid++;
            }
            if(checkMaze.contains("G")) {
                goalValid++;
            }
        }

        if(startValid != 1 || goalValid != 1) {
          throw new ExceptionInInitializerError("The maze is invalid!");
        }

    }

    /**
     * Checks if a position is either white space, start position or goal position.
     * @param pos
     * @return true if its movable, otherwise false.
     */
    public boolean isMovable(Position pos) {

        try {

            String temp = (mazeData.get(pos.getY()));
            char arrayValue = temp.charAt(pos.getX());

            if(arrayValue == ' ' || arrayValue == 'G' || arrayValue == 'S') {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            e.fillInStackTrace();
        }

        return false;

    }

    /** Checks if a position is of character G.
     * @param pos
     * @return true if its goal, otherwise false.
     */
    public boolean isGoal(Position pos) {

        String temp = (mazeData.get(pos.getY()));
        char arrayValue = temp.charAt(pos.getX());

        if(arrayValue == 'G') {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Gets the start position of the maze.
     * @return the position of S, if there is no S, return null.
     */
    public Position getStartPosition() {


        for(int i = 0; i < mazeData.size(); i++) {
            String temp = mazeData.get(i);

            if(temp.contains("S")) {
                Position position = new Position(temp.indexOf('S'), i);
                return position;
            }
        }

        return null;
    }

}
