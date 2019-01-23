package com.jorgeacetozi.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.List;

class Vertex {
  String name;
  Integer minDistance;
  Vertex predecessor;
  List<Edge> edges;

  Vertex(String name) {
    this.name = name;
    this.edges = new ArrayList<>();
  }

  @Override
  public String toString() {
    return this.name + " " + minDistance;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vertex other = (Vertex) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}
