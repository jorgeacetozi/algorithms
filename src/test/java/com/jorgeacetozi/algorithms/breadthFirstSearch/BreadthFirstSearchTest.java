package com.jorgeacetozi.algorithms.breadthFirstSearch;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class BreadthFirstSearchTest {

  BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
  Vertex root;
  
  @Before
  public void initGraph() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    Vertex f = new Vertex("F");

    a.neighbors.addAll(Arrays.asList(b, c));
    b.neighbors.addAll(Arrays.asList(a, c, e));
    c.neighbors.addAll(Arrays.asList(a, b, d, f));
    d.neighbors.addAll(Arrays.asList(c, e, f));
    e.neighbors.addAll(Arrays.asList(b, d));
    f.neighbors.addAll(Arrays.asList(c, d));
    root = a;
  }

  @Test
  public void shouldTraverseGraphUsingBFS() {
    breadthFirstSearch.bfs(root);
  }

  @Test
  public void shouldTraverseGraphUsingBFSOptimized() {
    breadthFirstSearch.bfsOptimized(root);
  }
}
