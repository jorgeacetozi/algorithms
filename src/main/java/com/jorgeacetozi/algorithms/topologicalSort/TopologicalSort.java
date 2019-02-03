package com.jorgeacetozi.algorithms.topologicalSort;

import java.util.Stack;

public class TopologicalSort {

  Stack<Vertex> stack = new Stack<>();

  // Basically it is a DFS which adds completely explored nodes (after visiting all of its children)
  // to a stack. Popping out the elements from the Stack will give the Topological Order
  void topologicalSort(Vertex vertex) {
    if (vertex.visited == false) {
      vertex.visited = true;
      for (Vertex neighbor : vertex.neighbors) {
        topologicalSort(neighbor);
      }
      stack.add(vertex);
    }
  }

  void printTopologicalOrder() {
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " -> ");
    }
  }
}
