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
        neighbor.predecessor = vertex;
        detectWithDFS(neighbor);
      }
    }
    vertex.visited = true;
    vertex.beingVisited = false;
    return this.found;
  }

  void printCycle(Vertex start) {
    printRecursive(start, start.predecessor);
    System.out.println(start);
  }

  private void printRecursive(Vertex start, Vertex aux) {
    if (aux == start) {
      System.out.print(aux);
      return;
    }
    printRecursive(start, aux.predecessor);
    System.out.print(aux);
  }
}
