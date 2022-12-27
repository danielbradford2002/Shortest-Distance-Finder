
import java.util.Scanner;

/**
 * This class provides the user interface where the user can find shortest
 * distances and paths between locations on UW Madison campus
 */
public class PathFinderFrontend implements IPathFinderFrontend {

    String[] locations;
    PathFinderBackend_Placeholder backend;

    /**
     * Constuctor that pulls the valid locaitons from back end object
     *
     * @param backend
     */
    public PathFinderFrontend(PathFinderBackend_Placeholder backend) {
        this.backend = backend;
        locations = backend.buildingOptions();

    }

    /**
     * Displays the welcome statement
     */
    public void displayStart() {
        System.out.println("Welcome to the UW Madison Shortest Path Finder!");
        System.out.println("===============================================\n");
    }


    @Override
/**
 * Runs the command loop where the user can input commands and the text is
 * displayed
 *
 * @param input the scanner object that will read the users input
 */
public void runCommandLoop(Scanner input) {

        int from = 0;
        int to = 0;
        displayMainMenu();
        while (input.hasNext()) {

        switch (input.next()) {

        case "1": {
        System.out.println("You are in the shortest path finder\n");
        displayLocations();
        System.out.println("\nWhich location are you coming from?");
        from = input.nextInt();
        System.out.println("\nWhich location are you heading to?");
        to = input.nextInt();

        findShortestDistance(from, to);
        break;

        }
        case "2": {
        displayAllDistances();
        break;
        }
        case "3": {
        System.out.println("Thank you for using the UW-Madison Shortest Path Finder!");
        return;
        }
default: {
        System.out.println("Please select one of the above options");
        }
        }
        displayMainMenu();
        }

        }

@Override
/**
 * Displays the various options the user can choose in the main menu
 */
public void displayMainMenu() {
        System.out.println(
        "\nYou are in the Main Menu:\n1) Find shortest Path\n2) Display distances between all locations\n3) Exit\n");

        }
@Override
/**
 * Displays all possible locations
 */
public void displayLocations() {

        for (int i = 0; i < locations.length; ++i) {
        System.out.println((i + 1) + ") " + locations[i]);
        }
        System.out.println();

        }

@Override
/**
 * Displays the distance relationship between various locations
 */
public void displayAllDistances() {
        System.out.println("The distances between locations (in miles) are:");
        for (int i = 0; i < locations.length; ++i) {
        for (int j = i; j < locations.length; ++j) {
        if (i == j) {
        continue;
        }
        System.out.println(locations[i] + " --" + backend.distanceFinder(locations[i], locations[j]) + "-- "
        + locations[j]);
        }
        }
        System.out.println();
        }

@Override
/**
 * Finds the shortest distance between two locations
 *
 * @param from int representing start location
 * @param to   int representing end location
 */
public void findShortestDistance(int from, int to) {

        String[] path = backend.pathFinder(locations[from - 1], locations[to - 1]);
        String sequence = "\t";
        System.out.println("\nThe shortest path from " + locations[from - 1] + " to " + locations[to - 1] + " is:\n");

        for (int i = 0; i < path.length - 1; ++i) {

        sequence += path[i] + " -> ";
        }

        sequence += path[path.length - 1];
        System.out.println(sequence);
        System.out.println(
        "\tWith a distance of " + backend.distanceFinder(locations[from - 1], locations[to - 1]) + " miles\n");

        }

        }