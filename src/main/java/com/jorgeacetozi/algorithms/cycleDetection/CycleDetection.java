package com.jorgeacetozi.algorithms.cycleDetection;

class CycleDetection {
  boolean found;

  boolean detectWithDFS(Vertex vertex) {
    if (vertex.beingVisited == true) {
      this.found = true;
      return this.found;
    }

    if (vertex.visited == false) {
      vertex.visited = false;
      vertex.beingVisited = true;
      for (Vertex neighbor : vertex.neighbors) {
        neighbor.predecessor = vertex; // using the predecessor allows to print the vertices in the
                                       // cycle, but you don't need it if you don't want to print
                                       // the cycle
        detectWithDFS(neighbor);
      }
    }
    vertex.visited = true;
    vertex.beingVisited = false;
    return this.found;
  }

  boolean AlternativeDetectWithDFS(Vertex vertex) {
    boolean found = false;

    if (vertex.beingVisited == true) {
      found = true;
      return found;
    }

    if (vertex.visited == false) {
      vertex.visited = false;
      vertex.beingVisited = true;
      for (Vertex neighbor : vertex.neighbors) {
        neighbor.predecessor = vertex; // using the predecessor allows to print the vertices in the
                                       // cycle, but you don't need it if you don't want to print
                                       // the cycle
        found = found || detectWithDFS(neighbor);
      }
    }
    vertex.visited = true;
    vertex.beingVisited = false;
    return found;
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
