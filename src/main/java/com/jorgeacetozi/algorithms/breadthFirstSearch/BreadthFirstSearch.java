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
        // avoid infinite loop due to cycles by visiting each vertex only once
        if (neighbor.visited == false) {
          /*
           * Mark the neighbor as visited, although we have not actually visited it yet. This plus
           * the if above avoid considering (printing, for example) a node twice when traversing the
           * graph. In BFS and DFS, visited = true actually means visited + beingVisited = true
           */
          neighbor.visited = true;
          System.out.print(neighbor.name);
          queue.add(neighbor);
        }
      }
    }
  }
}
