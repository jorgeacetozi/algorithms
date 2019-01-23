package com.jorgeacetozi.algorithms.dijkstra;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {
  
  Dijkstra dijkstra = new Dijkstra();
  List<Vertex> vertices;
  
  @Before
  public void initGraph(){
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Vertex vertexF = new Vertex("F");
    Vertex vertexG = new Vertex("G");
    Vertex vertexH = new Vertex("H");

    Edge edgeAB = new Edge(vertexA, vertexB, 5);
    Edge edgeAH = new Edge(vertexA, vertexH, 8);
    Edge edgeAE = new Edge(vertexA, vertexE, 9);
    vertexA.edges.addAll(Arrays.asList(edgeAB, edgeAH, edgeAE));

    Edge edgeBH = new Edge(vertexB, vertexH, 4);
    Edge edgeBC = new Edge(vertexB, vertexC, 12);
    Edge edgeBD = new Edge(vertexB, vertexD, 15);
    vertexB.edges.addAll(Arrays.asList(edgeBH, edgeBC, edgeBD));

    Edge edgeCD = new Edge(vertexC, vertexD, 3);
    Edge edgeCG = new Edge(vertexC, vertexG, 11);
    vertexC.edges.addAll(Arrays.asList(edgeCD, edgeCG));

    Edge edgeDG = new Edge(vertexD, vertexG, 9);
    vertexD.edges.add(edgeDG);

    Edge edgeEH = new Edge(vertexE, vertexH, 5);
    Edge edgeEF = new Edge(vertexE, vertexF, 4);
    Edge edgeEG = new Edge(vertexE, vertexG, 20);
    vertexE.edges.addAll(Arrays.asList(edgeEG, edgeEF, edgeEH));

    Edge edgeFC = new Edge(vertexF, vertexC, 1);
    Edge edgeFG = new Edge(vertexF, vertexG, 13);
    vertexF.edges.addAll(Arrays.asList(edgeFC, edgeFG));

    Edge edgeHC = new Edge(vertexH, vertexC, 7);
    Edge edgeHF = new Edge(vertexH, vertexF, 6);
    vertexH.edges.addAll(Arrays.asList(edgeHC, edgeHF));
    
    vertices = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH);
  }
  
  @Test
  public void shouldReturnShortestPathFromAToG(){
    Vertex vertexA = vertices.get(vertices.indexOf(new Vertex("A")));
    List<Vertex> shortestPathTree = dijkstra.shortestPathTree(vertices, vertexA);
    assertThat(shortestPathTree.get(shortestPathTree.indexOf(new Vertex("G"))).minDistance, is(25));
    assertThat(dijkstra.getShortestPathTo(shortestPathTree.get(shortestPathTree.indexOf(new Vertex("G"))), ""), is("AEFCG"));
  }
}
