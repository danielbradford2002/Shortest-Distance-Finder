import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
    import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
public class DataWranglerTests {
        private HouseLoader testLoader;
    static PathFinderFrontend frontend;
    Scanner scan;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @BeforeAll
    public static void initialize() {

        PathFinderBackend_Placeholder backend = new PathFinderBackend_Placeholder();

        frontend = new PathFinderFrontend(backend);
        frontend.displayStart();

    }

        /**
         * tests the second element of the returned array list from loadLocations equals the second
         * element in the test array list, which is the expected second element based on the file
         */
        @Test
        public  void testOne() throws IOException {
            ArrayList<String> testArrayList = new ArrayList<>();
            testArrayList.add("Gordons Dining Hall");
            testArrayList.add("Witte Residence Hall");
            testArrayList.add("Sellery Residence Hall");
            String testString = LocationLoader.loadLocations("LocationsUnder0.2Miles").get(2);
            assertEquals(testArrayList.get(2), testString);
        }
        @Test
        /**
         * tests that the getNeighbors method successfully adds Witte Residence hall as a
         * neighbor of the Kohl Center and checks that the value paired with Witte is 0.1
         */
        public  void testTwo() throws IOException, ParserConfigurationException, SAXException {
                HashMap<String, Double> testMap = new HashMap<>();
                testMap.put("Witte Residence Hall", 0.1);
                HashMap actualMap = LocationLoader.getNeighbors("Kohl Center", "LocationsUnder0" +
                    ".2Miles");
                assertEquals(testMap.get("Witte Residence Hall"),actualMap.get("Witte Residence " +
                        "Hall"));
        }
        @Test
        /**
         * tests that the getNeighbors method does not add a location that is not a neighbor to
         * the hashtable of neighbors because Memorial Union is not a neighbor of the Kohl Center
         */
        public  void testThree() throws FileNotFoundException {
                HashMap actualMap = LocationLoader.getNeighbors("Kohl Center", "LocationsUnder0" +
                        ".2Miles");
                assertEquals(false, actualMap.containsKey("Memorial Union"));
        }
        @Test
        /**
         * tests that a FileNotFound Exception is thrown for getNeighbors when an incorrect file is
         * passed into
         * the method
         */
        public  void testFour() throws FileNotFoundException {
                try {
                        HashMap actualMap = LocationLoader.getNeighbors("Kohl Center",
                                "incorrectFile");
                    assertEquals(false, true); //if exception not caught
                } catch(FileNotFoundException e){
                    String exceptionString = "successfully caught the fileNotFound exception";
                        System.out.println(exceptionString);
                        assertEquals(true, true);
                }


        }
        @Test
        /**
         * tests that the neighbors HashMap is empty when starting from a point that does not
         * exist in the file
         */
        public  void testFive() throws FileNotFoundException {
                HashMap actualMap = LocationLoader.getNeighbors("Kohl Centr",
                        "LocationsUnder0.2Miles");
                assertEquals(true, actualMap.isEmpty());
        }
    /**
     * tests the size of the returned array list from loadLocations to ensure that it is adding
     * the correct amount of locations to the list and not accidentally mistaking a
     * repeated destination for an additional starting point
     */
    @Test
    public void testSix() throws IOException {
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("Gordons Dining Hall");
        testArrayList.add("Witte Residence Hall");
        testArrayList.add("Sellery Residence Hall");
        testArrayList.add("Kohl Center");
        testArrayList.add("Grainger Hall");
        testArrayList.add("Chazen Museum of Art");
        testArrayList.add("Memorial Union");
        testArrayList.add("Memorial Library");
        testArrayList.add("Historical Society"); //last element
        int arrSize =
                LocationLoader.loadLocations("LocationsUnder0.2Miles").size();

        assertEquals(testArrayList.size(), arrSize);
    }

    /**
     * tests the last element of the returned array list from loadLocations equals the last
     * element in the test array list, which is the expected last element based on the file
     */
    @Test
    public  void testSeven() throws IOException {
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("Gordons Dining Hall");
        testArrayList.add("Witte Residence Hall");
        testArrayList.add("Sellery Residence Hall");
        testArrayList.add("Kohl Center");
        testArrayList.add("Grainger Hall");
        testArrayList.add("Chazen Museum of Art");
        testArrayList.add("Memorial Union");
        testArrayList.add("Memorial Library");
        testArrayList.add("Historical Society"); //last element
        String testString =
                LocationLoader.loadLocations("LocationsUnder0.2Miles").get(8);
        assertEquals(testArrayList.get(8), testString);
    }
    /**
     * Checks if the findShortestDistance method correctly throws and catches a
     * NullPointerException from when a user inputs a number representing a location that is not
     * one of the available options to choose from
     */
    @Test
    public  void testCodeReviewOfFrontEndDeveloper1() throws IOException {
        try {
            FrontendDeveloperTests.frontend.findShortestDistance(1, 8); //eight doesn't exist in
            // this part
            assertTrue(false);// because the exception should catch this failed input
        } catch (NullPointerException e) {
            System.out.println(e);
            assertTrue(true);
        }
    }
    /**
     * Checks if an ArrayIndexOutOfBoundsException is caught from the runCommandLoop method when a
     * user inputs a number representing an option that is greater than the options from the
     * given list of numbers
     */
    @Test
    public  void testCodeReviewOfFrontEndDeveloper2() throws IOException {
            try {
                String input = "1 5 4 3";
                scan = new Scanner(input);
                frontend.runCommandLoop(scan);
                assertTrue(false);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                assertTrue(true);
            }
        }
    }




