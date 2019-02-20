package com.jorgeacetozi.algorithms.connectivity;

import java.util.List;

class OptimizedConnectivity {

  boolean isConnected(List<Vertex> vertices) {
    int numberOfVisitedNodes = DFS(vertices.get(0), 0);
    return numberOfVisitedNodes == vertices.size();
  }

  private int DFS(Vertex vertex, int count) {
    if (vertex.visited == false) {
      vertex.visited = true;
      count++;
      for (Vertex neighbor : vertex.neighbors) {
        count = DFS(neighbor, count);
      }
    }
    return count;
  }
}
