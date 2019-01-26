package com.jorgeacetozi.algorithms.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

class BreadthFirstSearch {

  /*
   * This implementation simply: 
   * 1) Add the initial node to the queue; 
   * 2) While the queue is not empty, it dequeues a Vertex
   * 3) If this vertex isn't visited, then visit it and adds all of its neighbors to the queue
   * 
   * Note that it strictly visits only the currentVertex on each iteration, which makes sense conceptually (if
   * are in A, why would you be visiting A, B and C instead of only A?) but is less optimized than
   * the implementation below, which visits the neighbors before actually iterating over them.
   */
  void bfs(Vertex vertex) {
    Queue<Vertex> queue = new ArrayDeque<>();
    queue.add(vertex);
    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.poll();
      if (currentVertex.visited == false) {
        currentVertex.visited = true;
        System.out.print(currentVertex);
        for (Vertex neighbor : currentVertex.neighbors) {
          queue.add(neighbor);
        }
      }
    }
  }

  void bfsOptimized(Vertex vertex) {
    Queue<Vertex> queue = new ArrayDeque<>(); // BFS relies on the Queue ADT
    System.out.print(vertex.name);
    vertex.visited = true;
    queue.add(vertex);

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
