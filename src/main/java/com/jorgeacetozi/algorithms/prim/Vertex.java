package com.jorgeacetozi.algorithms.prim;

import java.util.ArrayList;
import java.util.List;

class Vertex {
  String name;
  int minWeight;
  List<Edge> edges;
  
  Vertex(String name) {
    this.name = name;
    edges = new ArrayList<>();
  }
  
  @Override
  public String toString() {
    return this.name;
  }
}
