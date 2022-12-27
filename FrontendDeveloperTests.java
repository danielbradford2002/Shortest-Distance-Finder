import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

/**
 * This class check the functionality of PathFinderFrontend class
 */
public class FrontendDeveloperTests {

    static PathFinderFrontend frontend;
    Scanner scan;

    @BeforeAll
    public static void initialize() {

        PathFinderBackend_Placeholder backend = new PathFinderBackend_Placeholder();

        frontend = new PathFinderFrontend(backend);
        frontend.displayStart();

    }

    @Test
    /**
     * Checks if main menu is displayed properly
     */
    public void test1() {
        try {
            System.out.println("TEST 1 ========================");
            String input = "3";
            scan = new Scanner(input);

            frontend.runCommandLoop(scan);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    /**
     * Checks if output is correct when the user wants to find the shortest path
     */
    public void test2() {

        try {
            System.out.println("TEST 2 ========================");
            String input = "1 3 4 3";
            scan = new Scanner(input);

            frontend.runCommandLoop(scan);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    /**
     * Checks if output is correct when the user wants to view the shortest
     * distances
     */
    public void test3() {
        try {
            System.out.println("TEST 3 ========================");
            String input = "2 3";
            scan = new Scanner(input);

            frontend.runCommandLoop(scan);
            assertTrue(true);

        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    /**
     * Checks if output is correct when user selects invalid number in main menu
     */
    public void test4() {

        try {
            System.out.println("TEST 4 ========================");
            String input = "4";
            scan = new Scanner(input);

            frontend.runCommandLoop(scan);
            assertTrue(true);
        } catch (Exception e) {

            assertTrue(false);
        }

    }

    @Test
    /**
     * Checks if output is correct when user wants to view distance between two
     * locations
     */
    public void test5() {

        try {
            System.out.println("TEST 5 ========================");
            frontend.findShortestDistance(1, 4);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    /**
     * Checks if an exception is caught when a user inputs a number representing a location that
     * is not one of the options to choose from
     */
    public void test6() {

        try {
            System.out.println("TEST 5 ========================");
            frontend.findShortestDistance(1, 8); //eight doesn't exist in this part
            assertTrue(false);// because the exception should catch this failed input
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}