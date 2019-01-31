package com.jorgeacetozi.algorithms.prim;

class Edge {
  Vertex start;
  Vertex end;
  int weight;
  
  Edge(Vertex start, Vertex end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }
}
