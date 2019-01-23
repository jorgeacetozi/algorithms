package com.jorgeacetozi.algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

class Vertex {
  String name;
  boolean visited;
  List<Vertex> neighbors;
  
  Vertex(String name) {
    this.name = name;
    this.visited = false;
    this.neighbors = new ArrayList<>();
  }
  
  @Override
  public String toString() {
    return this.name;
  }
}
