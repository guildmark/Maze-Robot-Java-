import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * A memory robot that remembers where its previous poisitions while walking through a maze to the goal
 * using depth-first-search.
 */
public class MemoryRobot extends Robot {


    private List<Position> neighbourPositions = new ArrayList<>();
    private List<Position> visitedPositions = new ArrayList<>();
    private Stack<Position> stack;

    public MemoryRobot(Maze robotMaze) {
        super(robotMaze);
    }

    /**
     * Moves to the first movable spot in the maze checking north and goes clockwise.
     * Keeps track of possible positions with a stack, and moves by a depth-first search of the maze.
     */
    @Override
    public void move() throws EmptyStackException {

        Position pos = getCurrentPosition();

        this.neighbourPositions.add(pos.getPosToSouth());
        this.neighbourPositions.add(pos.getPosToWest());
        this.neighbourPositions.add(pos.getPosToNorth());
        this.neighbourPositions.add(pos.getPosToEast());


        this.stack = new Stack<>();
        this.stack.add(pos);
        this.visitedPositions.add(pos);




        }


        /*
        //Add current position to stack.
        this.stack.push(pos);


        if (!stack.isEmpty()) {

            pos = stack.peek();
            stack.pop();

            //Add movable neighbours to the stack that hasnt been visited
            addNeighboursToStack(pos);

            if(!visitedPositions.contains(pos)) {
                visitedPositions.add(pos);
            }

            pos = stack.peek();

            //Move the robot to the current top of stack.
            setCurrentPosition(pos);
        }
        */


    }


    /**
     * Adds neighbouring positions that are movable and not visited to stack to aid with
     * depth first search.
     * @param pos
     */

