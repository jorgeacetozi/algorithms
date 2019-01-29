package com.jorgeacetozi.algorithms.connectivity;

import java.util.List;

class Connectivity {

  /*
   * Checks whether an UNDIRECTED graph is connected or not by simply running a DFS on a random
   * vertex and then verifying if there is still a vertex that hasn't been visited. If there is,
   * that's because this vertex is not connected to the rest of the graph
   */
  boolean isConnected(List<Vertex> vertices) {
    dfs(vertices.get(0));

    for (Vertex vertex : vertices) {
      if (vertex.visited == false) {
        return false;
      }
    }
    return true;
  }

  private void dfs(Vertex vertex) {
    if (vertex.visited == false) {
      vertex.visited = true;
      for (Vertex neighbor : vertex.neighbors) {
        dfs(neighbor);
      }
    }
  }

}
