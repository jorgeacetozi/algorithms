package com.jorgeacetozi.algorithms.connectivity;

import java.util.ArrayList;
import java.util.List;

class Vertex {
  String name;
  List<Vertex> neighbors;
  boolean visited;
  
  Vertex(String name) {
    this.name = name;
    this.neighbors = new ArrayList<>();
    this.visited = false;
  }
  @Override
  public String toString() {
    return this.name;
  }
}
