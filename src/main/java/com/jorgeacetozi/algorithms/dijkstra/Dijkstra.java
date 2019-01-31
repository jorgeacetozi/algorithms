package com.jorgeacetozi.algorithms.dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {

  // The Eager Dijkstra implementation does not insert vertices to heap whenever
  // a smaller distance is found. Instead, it updates the existing vertices in the
  // Priority Queue. In order to do that in O(log(n)), an IndexedPriorityQueue would be
  // necessary, so let's just remove and insert the vertice again in O(n) when a smaller
  // distance is found to make it simpler
  void eagerDijkstraShortestPath(List<Vertex> vertexList, Vertex source) {
    // init phase
    PriorityQueue<Vertex> minHeap =
        new PriorityQueue<>(Comparator.comparingInt(v -> v.minDistance));

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
        Vertex neighborVertex = edge.end;

        // Dijkstra doesn't need to verify if the neighbor is already visited because this condition
        // is enough
        if (currentVertex.minDistance + edge.weight < neighborVertex.minDistance) {
          minHeap.remove(neighborVertex); // takes O(n)
          neighborVertex.minDistance = currentVertex.minDistance + edge.weight;
          neighborVertex.predecessor = currentVertex;
          minHeap.add(neighborVertex); // takes O(log(n))
        }
      }
    }
  }

  String getShortestPathTo(Vertex vertex) {
    return getShortestPathRecursive(vertex, "");
  }

  private String getShortestPathRecursive(Vertex vertex, String path) {
    if (vertex == null) {
      return path;
    }
    return getShortestPathRecursive(vertex.predecessor, vertex.name + path);
  }
}
