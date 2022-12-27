import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * this interface provides the layout for locationLoader which will implement this interface
 */
public interface ILocationLoader {
    /**
     * Reads the objects in from the XML file and converts them into a list of Location objects for
     * the Backend Engineer to use
     *
     * @param filename the file in String format that will be read
     * @return a List containing the Location objects from the file
     * @throws FileNotFoundException if file is not found
     */
    public List<String> loadLocations(String filename) throws FileNotFoundException;

    /**
     * @param startPoint the location that we are finding the neighbors for
     * @param filename   the file that contains the data that is being read
     * @return a hashtable with each neighbor of startPoint as keys and a double that contains the
     * distance to each of the neighbors as the corresponding value
     * @throws FileNotFoundException if the file passed in cannot be found
     */
    public HashMap<String, Double> getNeighbors(String startPoint, String filename)
            throws FileNotFoundException;
}
