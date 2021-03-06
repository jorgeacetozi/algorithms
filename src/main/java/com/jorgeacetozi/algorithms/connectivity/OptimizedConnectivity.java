package com.jorgeacetozi.algorithms.connectivity;

import java.util.List;

/*
 * Count all visited vertices using DFS and compare it to the total number of vertices in the graph
 */
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


  private int AlternativeDFS(Vertex vertex) { // Return the count without having to carry the
                                              // counter as a method parameter
    int count = 0;
    if (vertex.visited == false) {
      vertex.visited = true;
      count++;
      for (Vertex neighbor : vertex.neighbors) {
        count = count + AlternativeDFS(neighbor);
      }
    }
    return count;
  }
}
