package com.jorgeacetozi.algorithms.topologicalSort;

import java.util.Arrays;
import org.junit.Test;

public class TopologicalSortTest {

  TopologicalSort topologicalSort = new TopologicalSort();

  @Test
  public void shouldGenerateTopologicalSort() {
    Vertex logic = new Vertex("logic");
    Vertex programming1 = new Vertex("programming1");
    Vertex programming2 = new Vertex("programming2");
    Vertex operatingSystems = new Vertex("operatingSystems");
    
    logic.neighbors.addAll(Arrays.asList(programming1, programming2));
    programming1.neighbors.addAll(Arrays.asList(programming2, operatingSystems));
    programming2.neighbors.add(operatingSystems);
    
    topologicalSort.topologicalSort(logic);
    topologicalSort.printTopologicalOrder();
  }
}
