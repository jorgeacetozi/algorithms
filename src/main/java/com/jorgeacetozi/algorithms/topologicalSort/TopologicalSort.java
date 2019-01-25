package com.jorgeacetozi.algorithms.topologicalSort;

import java.util.Stack;

public class TopologicalSort {

  Stack<Vertex> stack = new Stack<>();

  // Basically a DFS which adds completely explored nodes (after visiting all its childrem) to a
  // stack. Poping out the elements from the Stack will give the Topological Order.
  void topologicalSort(Vertex vertex) {
    vertex.visited = true;

    for (Vertex neighbor : vertex.neighbors) {
      if (neighbor.visited == false) {
        topologicalSort(neighbor);
      }
    }

    stack.add(vertex);
  }

  void printTopologicalOrder() {
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " -> ");
    }
  }
}
