package com.jorgeacetozi.algorithms.prim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Prim {

  List<Vertex> minimumSpanningTree(List<Vertex> vertices) {
    List<Vertex> minimumSpanningTree = new ArrayList<>();
    PriorityQueue<Vertex> unvisitedVertices =
        new PriorityQueue<>(Comparator.comparingInt(v -> v.minWeight));

    for (Vertex vertex : vertices) {
      vertex.minWeight = Integer.MAX_VALUE;
    }
    Vertex randomStartingVertex = vertices.get(3); // It could have been any vertex
    randomStartingVertex.minWeight = 0;

    unvisitedVertices.addAll(vertices);

    while (!unvisitedVertices.isEmpty()) {
      Vertex currentVertex = unvisitedVertices.poll();
      minimumSpanningTree.add(currentVertex);

      for (Edge edge : currentVertex.edges) {
        Vertex targetVertex = edge.end;

        if (edge.weight < targetVertex.minWeight && unvisitedVertices.contains(targetVertex)) {
          unvisitedVertices.remove(targetVertex);
          targetVertex.minWeight = edge.weight;
          unvisitedVertices.add(targetVertex);
        }
      }
    }
    return minimumSpanningTree;
  }

}
