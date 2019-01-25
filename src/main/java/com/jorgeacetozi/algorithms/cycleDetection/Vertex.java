package com.jorgeacetozi.algorithms.cycleDetection;

import java.util.ArrayList;
import java.util.List;

class Vertex {
  String name;
  List<Vertex> neighbors;
  boolean visited, beingVisited;
  
  Vertex(String name) {
    this.name = name;
    neighbors = new ArrayList<>();
    visited = beingVisited = false;
  }
  
  @Override
  public String toString() {
    return this.name;
  }
}
