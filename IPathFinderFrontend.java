import java.util.Scanner;

/**
 * This interface provides the layout for the PathFinderFrontend class which
 * will implement this
 */
public interface IPathFinderFrontend {

    /**
     * Runs the command loop where the user can input commands and the text is
     * displayed
     *
     * @param input the scanner object that will read the users input
     */
    public void runCommandLoop(Scanner input);

    /**
     * Displays the various options the user can choose in the main menu
     */
    public void displayMainMenu();

    /**
     * Displays all possible locations
     */
    public void displayLocations();

    /**
     * Displays the distance relationship between various locations
     */
    public void displayAllDistances();

    /**
     * Finds the shortest distance between two locations
     *
     * @param from int representing start location
     * @param to   int representing end location
     */
    public void findShortestDistance(int from, int to);

}
