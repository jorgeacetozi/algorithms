package com.jorgeacetozi.algorithms.dijkstra;

class Edge {
  Vertex start;
  Vertex end;
  int weight;

  Edge(Vertex start, Vertex end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }
  
  @Override
  public String toString() {
    return String.format("%s -> %s : %d", this.start, this.end, this.weight);
  }
}
