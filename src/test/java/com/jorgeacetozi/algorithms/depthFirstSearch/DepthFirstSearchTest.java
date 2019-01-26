package com.jorgeacetozi.algorithms.depthFirstSearch;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.jorgeacetozi.algorithms.depthFirstSearch.Vertex;

public class DepthFirstSearchTest {

  DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
  Vertex root;

  @Before
  public void createGraph() {
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Vertex vertexF = new Vertex("F");

    vertexA.neighbors.addAll(Arrays.asList(vertexB, vertexC));
    vertexB.neighbors.addAll(Arrays.asList(vertexA, vertexC, vertexE));
    vertexC.neighbors.addAll(Arrays.asList(vertexA, vertexB, vertexD, vertexF));
    vertexD.neighbors.addAll(Arrays.asList(vertexC, vertexE, vertexF));
    vertexE.neighbors.addAll(Arrays.asList(vertexB, vertexD));
    vertexF.neighbors.addAll(Arrays.asList(vertexC, vertexD));
    root = vertexA;
  }

  @Test
  public void iterativeDFSTest() {
    depthFirstSearch.iterativeDFS(root);
  }
  
  @Test
  public void iterativeDFSOptimizedTest() {
    depthFirstSearch.iterativeDFSOptimized(root);
  }

  @Test
  public void recursiveDFSTest() {
    depthFirstSearch.recursiveDFS(root);
  }
}
