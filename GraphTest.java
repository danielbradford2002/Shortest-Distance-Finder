import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String,Integer> graph;
    private CS400Graph<String,Integer> graph2;

    /**
     * Instantiate graph.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
        graph2 = new CS400Graph<>();
        graph2.insertVertex("A");
        graph2.insertVertex("B");
        graph2.insertVertex("C");
        graph2.insertVertex("D");
        graph2.insertEdge("A","B",6);
        graph2.insertEdge("B","C",2);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertEquals(3,graph.getPathCost("A", "F"));
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertEquals(4,graph.getPathCost("A", "D"));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
                "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
                "[A, C, F]"
        ));
    }
    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        assertEquals(6,graph.getPathCost("A", "E"));
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to E.
     */
    @Test
    public void testPathAtoE() {
        assertTrue(graph.shortestPath("A", "E").toString().equals(
                "[A, C, B, E]"
        ));
    }
    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostBtoF() {
        assertEquals(3,graph.getPathCost("B", "F"));
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * B to F.
     */
    @Test
    public void testPathBtoF() {
        assertTrue(graph.shortestPath("B", "F").toString().equals(
                "[B, C, F]"
        ));
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to E.
     */
    @Test
    public void testPathDtoC() {
        assertTrue(graph.shortestPath("D", "C").toString().equals(
                "[D, E, A, C]"
        ));
    }

}
