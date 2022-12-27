import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class LocationLoader{
    /**
     * Reads the objects in from the XML file and converts them into a list of Location
     * objects for the Backend Engineer to use
     *
     * @param filename the file in String format that will be read
     * @return a List containing the Location objects from the file
     * @throws FileNotFoundException if file is not found
     */
    public static List<String> loadLocations(String filename)
            throws FileNotFoundException{
        List<String> allLocations = new ArrayList<>();
        try {
            File DOTFile = new File("src/" + filename);
            if (!DOTFile.exists()) {
                throw new FileNotFoundException();
            }
            Scanner scnr = new Scanner(DOTFile);
            scnr.nextLine(); //skips first line
            while (scnr.hasNextLine()) {
                String currLine = scnr.nextLine();
                if(!(currLine.trim().equals("}"))) {
                    int arrowIndex = currLine.indexOf("->");
                    String startingLocation = "";//String for the starting location
                    for (int i = 0; i < arrowIndex; i++) {
                        startingLocation = startingLocation + currLine.charAt(i);
                    }
                    startingLocation = startingLocation.replaceAll("\"", "");
                    startingLocation = startingLocation.trim();
                    if (!(allLocations.contains(startingLocation))) {
                        allLocations.add(startingLocation);
                    }
                }
            }
            for (int i = 0; i < allLocations.size(); i++) {
                System.out.println(allLocations.get(i)); //prints out all locations in the file
            }
        }catch(Exception e){
            System.out.println("error exception occured");
        }
        return allLocations;
    }

    /**
     *
     * @param startPoint the location that we are finding the neighbors for
     * @param filename the file that contains the data that is being read
     * @return a hashtable with each neighbor of startPoint as keys and a double that contains
     * the distance to each of the neighbors as the corresponding value
     * @throws FileNotFoundException if the file passed in cannot be found
     */
    public static HashMap<String,Double> getNeighbors(String startPoint, String filename)
            throws FileNotFoundException {
        File DOTFile = new File("src/" + filename);
        Scanner scnr = new Scanner(DOTFile);
        if (!DOTFile.exists()) {
            throw new FileNotFoundException();
        }
        scnr.nextLine(); //skips first line
        HashMap<String,Double> neighbors = new HashMap<>();
        while(scnr.hasNextLine()){
            String currLine = scnr.nextLine();
            int arrowIndex = currLine.indexOf("->");
            String startingLocation ="";//String for the starting location
            for(int i = 0; i<arrowIndex;i++) {
                startingLocation = startingLocation + currLine.charAt(i);
            }
            startingLocation= startingLocation.replaceAll("\"", "");
            int bracketLocation = currLine.indexOf("[");
            String destination = "";
            startingLocation=startingLocation.trim();
            if(startingLocation.equals(startPoint)) {
                for (int i = arrowIndex+2; i < bracketLocation; i++) {
                    destination = destination + currLine.charAt(i);
                }
                destination= destination.replace("\"", "");
                destination = destination.trim();
                int closedBracketIndex = currLine.indexOf("]");
                int equalSignIndex = currLine.indexOf("=");
                double distanceDouble = 0.0;
                String distanceString = "";
                for(int i = equalSignIndex +1; i<closedBracketIndex; i++){
                    distanceString = distanceString + currLine.charAt(i);
                }
                distanceString = distanceString.replace("\"","");
                distanceString.trim();
                distanceDouble = Double.parseDouble(distanceString);
                //  System.out.println(destination + " is " + distanceDouble +" miles away from " +
                //  startPoint);
                neighbors.put(destination, distanceDouble);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException,
            SAXException {
LocationLoader.loadLocations("LocationsUnder0.2Miles");
LocationLoader.getNeighbors("Witte Residence Hall", "LocationsUnder0.2Miles");

    }
}


