package com.jorgeacetozi.algorithms.dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {

  public List<Vertex> shortestPathTree(List<Vertex> vertexList, Vertex source) {
    // init phase
    PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.minDistance));
    for (Vertex vertex : vertexList) {
      if (vertex.equals(source)) {
        vertex.minDistance = 0;
      } else {
        vertex.minDistance = Integer.MAX_VALUE;
      }
      minHeap.add(vertex);
    }

    while (!minHeap.isEmpty()) {
      Vertex currentVertex = minHeap.poll();

      // relaxing edges phase
      for (Edge edge : currentVertex.edges) {
        Vertex neighborVertex = edge.to;

        if (currentVertex.minDistance + edge.weight < neighborVertex.minDistance) {
          minHeap.remove(neighborVertex); // takes O(n)
          neighborVertex.minDistance = currentVertex.minDistance + edge.weight;
          neighborVertex.predecessor = currentVertex;
          minHeap.add(neighborVertex); // takes O(log(n))
        }
      }
    }
    return vertexList;
  }

  public String getShortestPathTo(Vertex vertex, String path) {
    if (vertex == null) {
      return path;
    }
    return getShortestPathTo(vertex.predecessor, vertex.name + path);
  }
}
