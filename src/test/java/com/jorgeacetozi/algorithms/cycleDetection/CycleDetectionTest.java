package com.jorgeacetozi.algorithms.cycleDetection;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class CycleDetectionTest {

  CycleDetection cycleDetection = new CycleDetection();

  @Test
  public void shouldDetectCycle() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");

    a.neighbors = Arrays.asList(c);
    b.neighbors = Arrays.asList(d, a);
    c.neighbors = Arrays.asList(b);

    assertTrue(cycleDetection.detectWithDFS(a));
    cycleDetection.printCycle(a);
  }

  @Test
  public void shouldNotDetectCycle() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");

    a.neighbors = Arrays.asList(c);
    b.neighbors = Arrays.asList(d);
    c.neighbors = Arrays.asList(b);

    assertFalse(cycleDetection.detectWithDFS(a));
  }
}
