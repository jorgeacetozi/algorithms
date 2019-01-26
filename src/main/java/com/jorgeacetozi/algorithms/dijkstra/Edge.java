package com.jorgeacetozi.algorithms.dijkstra;

class Edge {
  Vertex start;
  Vertex end;
  Integer weight;

  Edge(Vertex start, Vertex end, Integer weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }
}
