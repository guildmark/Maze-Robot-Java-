/**
 * A robot with different functions to use to navigate a maze.
 */
public abstract class Robot {

    private Position position;
    protected Maze maze;

    /** Creates a new robot at the starting position of a maze.
     * @param robotMaze
     */
    public Robot(Maze robotMaze) {
        this.maze = robotMaze;
        this.position = robotMaze.getStartPosition();
    }

    /**
     * Move function to navigate through the maze from start to goal.
     */
    public abstract void move();

    /**
     * Gets the current position of the robot in the maze
     * @return current position.
     */
    public Position getCurrentPosition() {
        return this.position;
    }

    /**
     * Sets current position of the robot to a wanted position.
     * @param pos
     */
    protected void setCurrentPosition(Position pos) {
        this.position = pos;
    }

    /**
     * Checks if the current position of the robot is the goal position.
     * @return true if its the goal, otherwise false.
     */
    public boolean hasReachedGoal() {

        if(this.maze.isGoal(this.position)) {
            return true;
        }
        else {
            return false;
        }
    }

}
