package com.jorgeacetozi.algorithms.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  String name;
  List<Vertex> neighbors;
  boolean visited;
  
  public Vertex(String name) {
    this.name = name;
    this.visited = false;
    this.neighbors = new ArrayList<>();
  }
}
