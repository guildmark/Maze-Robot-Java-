/**
 * Robot that navigates through a maze by holding its right hand against the wall at all times.
 */
public class RightHandRuleRobot extends Robot {

    private enum Direction {NORTH, EAST, SOUTH, WEST,}

    private Direction direction;


    /**
     * Creates a new right hand robot in a maze, looking in south direction to start.
     * @param robotMaze
     */
    public RightHandRuleRobot(Maze robotMaze) {
        super(robotMaze);
        //Robot starts facing the south position
        this.direction = Direction.SOUTH;
    }


    /**
     * Navigates through the maze by the right-hand rule, one step at a time.
     */
    @Override
    public void move() {

        Position pos = getCurrentPosition();

        //Check is the position is movable while theres a while on the right.
        if (this.maze.isMovable(lookForward()) && !this.maze.isMovable(lookRight())) {
            moveForward();
        }
        //If there was a door that the robot walked through, maintain contact with the door while walking to the right
        else if (checkDoorWay(lookBehind()) && maze.isMovable(lookRight())) {
            turnRobotRight();
            moveForward();
        }

        //If u can walk left and theres a wall infront, turn left and walk
        else if (maze.isMovable(lookLeft()) && !maze.isMovable(lookForward())) {
            turnRobotLeft();
            moveForward();
        }
        //If robot can walk right and there is a wall behind it, move right.
        else if(maze.isMovable(lookRight()) && !maze.isMovable(lookBehind())) {
            turnRobotRight();
            moveForward();
        }


        //If nothing works, turn the robot to the right.
        else {
            turnRobotRight();
        }
    }


    /**
     * Moves the robot one position forward, taking into consideration the direction the robot is
     * looking in.
     */
    private void moveForward() {
        Position pos = getCurrentPosition();

        if(this.direction.equals(Direction.SOUTH)) {
            setCurrentPosition(pos.getPosToSouth());
        }
        else if(this.direction.equals(Direction.WEST)) {
            setCurrentPosition(pos.getPosToWest());
        }
        else if(this.direction.equals(Direction.EAST)) {
            setCurrentPosition(pos.getPosToEast());
        }
        else if(this.direction.equals(Direction.NORTH)) {
            setCurrentPosition(pos.getPosToNorth());
        }
    }

    /**
     * Turns the robot to the right, depending on the direction its currently facing.
     */
   private void turnRobotRight() {
       if (this.direction.equals(Direction.SOUTH)) {
           this.direction = Direction.WEST;
       } else if (this.direction.equals(Direction.WEST)) {
           this.direction = Direction.NORTH;
       } else if (this.direction.equals(Direction.NORTH)) {
           this.direction = Direction.EAST;
       } else if(this.direction.equals(Direction.EAST)) {
           this.direction = Direction.SOUTH;
       }
   }


    /**
     * Turns the robot to the left, depending on the direction its currently facing.
     */
   private void turnRobotLeft() {
        if (this.direction.equals(Direction.SOUTH)) {
            this.direction = Direction.EAST;
        }
        else if (this.direction.equals(Direction.WEST)) {
            this.direction = Direction.SOUTH;
        }
        else if(this.direction.equals(Direction.NORTH)) {
            this.direction = Direction.WEST;
        }
        else if(this.direction.equals(Direction.EAST)){
            this.direction = Direction.NORTH;
        }
   }

    /**
     * Looks to the left of the robot to see the position, depends on what direction
     * its currently looking in.
     * @return
     */
   private Position lookLeft() {
        Position pos = getCurrentPosition();

        if(this.direction.equals(Direction.SOUTH)) {
            return pos.getPosToEast();
        }
        else if (this.direction.equals(Direction.NORTH)) {
            return pos.getPosToWest();
        }
        else if(this.direction.equals(Direction.WEST)) {
            return pos.getPosToSouth();
        }
        else if (this.direction.equals(Direction.EAST)) {
            return pos.getPosToNorth();
        }
        else {
            return null;
        }
   }

    /**
     * Looks to the right position of the robot, depending on which direction its looking in.
     * @return the position right of the robot
     */
   private Position lookRight() {
        Position pos = getCurrentPosition();

        if (this.direction.equals(Direction.SOUTH)) {
            return pos.getPosToWest();
       }
       else if(this.direction.equals(Direction.NORTH)) {
            return pos.getPosToEast();
       }
       else if(this.direction.equals(Direction.WEST)) {
            return pos.getPosToNorth();
       }
       else if(this.direction.equals(Direction.EAST)) {
            return pos.getPosToSouth();
       }
       else {
            return null;
        }
   }

    /**
     * Looks straight ahead of the robot, depending on what direction its looking in.
     * @return the position ahead of the robot
     */
   private Position lookForward() {
        Position pos = getCurrentPosition();

        if(this.direction.equals(Direction.SOUTH)) {
            return pos.getPosToSouth();
        }
        else if(this.direction.equals(Direction.EAST)) {
            return pos.getPosToEast();
        }
        else if(this.direction.equals(Direction.WEST)) {
            return pos.getPosToWest();
        }
        else if(this.direction.equals(Direction.NORTH)){
            return pos.getPosToNorth();
        }
        else {
            return null;
        }
   }

    /**
     * Looks to the position behind the robot, depending on what direction its looking in.
     * @return the position behind the robot.
     */
   private Position lookBehind() {
       Position pos = getCurrentPosition();

       if(this.direction.equals(Direction.NORTH)) {
           return pos.getPosToSouth();
       }
       else if(this.direction.equals(Direction.EAST)) {
           return pos.getPosToWest();
       }
       else if(this.direction.equals(Direction.WEST)) {
           return pos.getPosToEast();
       }
       else if(this.direction.equals(Direction.SOUTH)) {
           return pos.getPosToNorth();
       }
       else {
           return null;
       }
   }

    /**
     * Checks a position to see if it is a doorway with walls blocking its sides.
     * @param pos
     * @return true if there is a door, otherwise false.
     */
   private boolean checkDoorWay(Position pos) {
        if(maze.isMovable(pos) && !maze.isMovable(pos.getPosToWest()) && !maze.isMovable(pos.getPosToEast())){
            return true;
        }
        else if(maze.isMovable(pos) && !maze.isMovable(pos.getPosToSouth()) && !maze.isMovable(pos.getPosToNorth())) {
            return true;
        }
        else {
            return false;
        }
   }

}
