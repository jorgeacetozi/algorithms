package com.jorgeacetozi.algorithms.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

class BreadthFirstSearch {

  void bfs(Vertex u) {
    Queue<Vertex> queue = new ArrayDeque<>(); // BFS relies on the Queue ADT
    System.out.print(u.name);
    u.visited = true;
    queue.add(u);

    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.poll();

      for (Vertex neighbor : currentVertex.neighbors) {
        if (neighbor.visited == false) { // avoid infinite loop due to cycles by visiting each
                                         // vertex only once
          neighbor.visited = true; // mark the neighbor as visited, although we have not visited it yet
                                   // this + the if above avoid considering a node twice when traversing the graph
          System.out.print(neighbor.name);
          queue.add(neighbor);
        }
      }
    }
  }
}
