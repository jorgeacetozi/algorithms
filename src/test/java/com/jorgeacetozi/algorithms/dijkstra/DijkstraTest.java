package com.jorgeacetozi.algorithms.dijkstra;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DijkstraTest {

  Dijkstra dijkstra = new Dijkstra();
  List<Vertex> vertices;

  @Test
  public void shouldReturnShortestPathFromAToG() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    Vertex f = new Vertex("F");
    Vertex g = new Vertex("G");
    Vertex h = new Vertex("H");

    Edge ab = new Edge(a, b, 5);
    Edge ah = new Edge(a, h, 8);
    Edge ae = new Edge(a, e, 9);
    a.edges.addAll(Arrays.asList(ab, ah, ae));

    Edge bh = new Edge(b, h, 4);
    Edge bc = new Edge(b, c, 12);
    Edge bd = new Edge(b, d, 15);
    b.edges.addAll(Arrays.asList(bh, bc, bd));

    Edge cd = new Edge(c, d, 3);
    Edge cg = new Edge(c, g, 11);
    c.edges.addAll(Arrays.asList(cd, cg));

    Edge dg = new Edge(d, g, 9);
    d.edges.add(dg);

    Edge eh = new Edge(e, h, 5);
    Edge ef = new Edge(e, f, 4);
    Edge eg = new Edge(e, g, 20);
    e.edges.addAll(Arrays.asList(eg, ef, eh));

    Edge fc = new Edge(f, c, 1);
    Edge fg = new Edge(f, g, 13);
    f.edges.addAll(Arrays.asList(fc, fg));

    Edge hc = new Edge(h, c, 7);
    Edge hf = new Edge(h, f, 6);
    h.edges.addAll(Arrays.asList(hc, hf));

    vertices = Arrays.asList(a, b, c, d, e, f, g, h);

    List<Vertex> shortestPathTree = dijkstra.eagerDijkstraShortestPath(vertices, a);
    assertThat(shortestPathTree.get(shortestPathTree.indexOf(new Vertex("G"))).minDistance, is(25));

    String shortestPathFromAToG = dijkstra
        .getShortestPathTo(shortestPathTree.get(shortestPathTree.indexOf(new Vertex("G"))), "");
    assertThat(shortestPathFromAToG, is("AEFCG"));
  }

  @Test
  public void shouldReturnShortestPathFromAToD() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Edge ab = new Edge(a, b, 1);
    Edge ac = new Edge(a, c, 5);
    Edge bc = new Edge(b, c, 2);
    Edge bd = new Edge(b, d, 4);
    Edge cb = new Edge(c, b, 3);
    Edge cd = new Edge(c, d, 3);

    a.edges.addAll(Arrays.asList(ab, ac));
    b.edges.addAll(Arrays.asList(bc, bd));
    c.edges.addAll(Arrays.asList(cb, cd));

    List<Vertex> vertices = Arrays.asList(a, b, c, d);
    List<Vertex> shortestPathTree = dijkstra.eagerDijkstraShortestPath(vertices, a);
    assertThat(shortestPathTree.get(shortestPathTree.indexOf(new Vertex("D"))).minDistance, is(5));

    String shortestPathFromAToD = dijkstra.getShortestPathTo(d, "");
    assertThat(shortestPathFromAToD, is("ABD"));
  }
}
