package com.jorgeacetozi.algorithms.connectivity;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ConnectivityTest {

  Connectivity connectivity = new Connectivity();

  @Test
  public void shouldNotBeConnected() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    a.neighbors.addAll(Arrays.asList(b, c));
    b.neighbors.addAll(Arrays.asList(a, c));
    c.neighbors.addAll(Arrays.asList(a, b));
    d.neighbors.add(e);
    e.neighbors.add(d);
    List<Vertex> vertices = Arrays.asList(a, b, c, d, e);

    assertFalse(connectivity.isConnected(vertices));
  }

  @Test
  public void shouldBeConnected() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    a.neighbors.addAll(Arrays.asList(b, c, e));
    b.neighbors.addAll(Arrays.asList(a, c));
    c.neighbors.addAll(Arrays.asList(a, b));
    d.neighbors.addAll(Arrays.asList(a, e));
    e.neighbors.add(d);
    List<Vertex> vertices = Arrays.asList(a, b, c, d, e);

    assertTrue(connectivity.isConnected(vertices));
  }
}
