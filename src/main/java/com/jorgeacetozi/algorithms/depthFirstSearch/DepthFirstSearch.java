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
        if (neighbor.visited == false) {
          neighbor.visited = true;
          System.out.print(neighbor);
          stack.push(neighbor);
        }
      }
    }
  }
}
