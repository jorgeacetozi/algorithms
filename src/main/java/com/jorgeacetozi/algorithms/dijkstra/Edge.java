package com.jorgeacetozi.algorithms.dijkstra;

class Edge {
  Vertex from;
  Vertex to;
  Integer weight;

  Edge(Vertex from, Vertex to, Integer weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}
