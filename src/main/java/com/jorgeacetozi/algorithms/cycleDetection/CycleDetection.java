package com.jorgeacetozi.algorithms.cycleDetection;

class CycleDetection {
  boolean found;

  boolean detectWithDFS(Vertex vertex) {
    if (vertex.beingVisited == true) {
      this.found = true;
      return this.found;
    }
    vertex.visited = false;
    vertex.beingVisited = true;
    for (Vertex neighbor : vertex.neighbors) {
      if (neighbor.visited == false) {
        detectWithDFS(neighbor);
      }
    }
    vertex.visited = true;
    vertex.beingVisited = false;
    return this.found;
  }
}
