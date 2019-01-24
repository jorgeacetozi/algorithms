package com.jorgeacetozi.algorithms.depthFirstSearch;

import java.util.Stack;

class DepthFirstSearch {

  void iterativeDFS(Vertex vertex) {
    Stack<Vertex> stack = new Stack<>();
    vertex.visited = true;
    System.out.print(vertex);
    stack.push(vertex);

    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();

      for (Vertex neighbor : currentVertex.neighbors) {
        // avoid infinite loop due to cycles by visiting each vertex only once
        if (neighbor.visited == false) {
          /*
           * Mark the neighbor as visited, although we have not actually visited it yet. This plus
           * the if above avoid considering (printing, for example) a node twice when traversing the
           * graph. In BFS and DFS, visited = true actually means visited + beingVisited = true
           */
          neighbor.visited = true;
          System.out.print(neighbor);
          stack.push(neighbor);
        }
      }
    }
  }
}
