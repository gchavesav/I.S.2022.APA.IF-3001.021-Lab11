/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import domain.list.ListException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class AdjacencyMatrixGraphNGTest {
    
    public AdjacencyMatrixGraphNGTest() {
    }

    @Test
    public void test() {
        try {
            AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(10);
            for (int i = 1; i <= 10; i++) {
                graph.addVertex(i);
            }
            graph.addEdge(1, 3);
            graph.addEdge(2, 4);
            graph.addEdge(3, 6);
            graph.addEdge(4, 8);
            graph.addEdge(5, 10);
            System.out.println(graph.toString());
        } catch (GraphException | ListException ex) {
                Logger.getLogger(AdjacencyMatrixGraphNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
