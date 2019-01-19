package com.jorgeacetozi.algorithms.dijkstra;

public class Edge {
  Vertex from;
  Vertex to;
  Integer weight;

  public Edge(Vertex from, Vertex to, Integer weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}
