import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * RobotCompare takes a text file and creates a maze and runs the Memory robot and Right hand rule robot
 * against eachother to the finish line, prints out the amount of moves it took for the robots to complete.
 */
public class RobotCompare {

    public static void main(String[] args) throws FileNotFoundException {

        int memRobotMoves = 0;
        int rightHandRobotMoves = 0;

        //Fil den inte kan läsa in: mazecorrect.txt
        File file = new File("C:\\Users\\MK02\\IdeaProjects\\ou2real\\src\\mazebig.txt");
        Scanner scanner = new Scanner(file);
        Maze maze = new Maze(scanner);

        MemoryRobot memRobot = new MemoryRobot(maze);
        RightHandRuleRobot rightHandRobot = new RightHandRuleRobot(maze);


        //Race the robots against eachother
        System.out.println("Moving right hand rule robot...");

        while(!rightHandRobot.hasReachedGoal()) {
            rightHandRobot.move();
            rightHandRobotMoves++;
        }

        System.out.println("Right hand robot has reached the goal in: " + rightHandRobotMoves + " moves.");






        /*
        System.out.println("Moving memory robot...");

         while(!memRobot.hasReachedGoal()) {
            memRobot.move();
            memRobotMoves++;
         }

        System.out.println("Memory Robot has reached the goal in: " + memRobotMoves + " moves.");
        */

    }
}
