package com.jorgeacetozi.algorithms.breadthFirstSearch;

import java.util.Arrays;
import org.junit.Test;

public class BreadthFirstSearchTest {
  
  @Test
  public void shouldTraverseGraphUsingBFS(){
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Vertex vertexF = new Vertex("F");
    
    vertexA.neighbors.addAll(Arrays.asList(vertexB, vertexC));
    vertexB.neighbors.addAll(Arrays.asList(vertexA, vertexC, vertexE));
    vertexC.neighbors.addAll(Arrays.asList(vertexA, vertexB, vertexD));
    vertexD.neighbors.addAll(Arrays.asList(vertexC, vertexE, vertexF));
    vertexE.neighbors.addAll(Arrays.asList(vertexB, vertexD));
    vertexF.neighbors.addAll(Arrays.asList(vertexC, vertexD));
    
    new BreadthFirstSearch().BFS(vertexA);
  }
}
