package com.jorgeacetozi.algorithms.depthFirstSearch;

import java.util.Stack;

class DepthFirstSearch {

  /*
   * This implementation simply: 1) Add the initial node to the stack; 2) While the stack is not
   * empty, it pops out a Vertex 3) If this vertex isn't visited, then visit it and adds all of its
   * neighbors to the stack
   * 
   * Note that it only visits the currentVertex per iteration, which makes sense conceptually (if
   * are in A, why would you be visiting A, B and C instead of only A?) but is less optimized than
   * the implementation below, which visits the neighbors before actually iterating over them.
   */
  void iterativeDFS(Vertex vertex) {
    Stack<Vertex> stack = new Stack<>();
    stack.push(vertex);
    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();
      if (currentVertex.visited == false) {
        currentVertex.visited = true;
        System.out.print(currentVertex);
        for (Vertex neighbor : currentVertex.neighbors) {
          stack.push(neighbor);
        }
      }
    }
  }

  // Note this is the exact same piece of code as above, just without the stack declaration
  void recursiveDFS(Vertex vertex) {
    if (vertex.visited == false) {
      vertex.visited = true;
      System.out.print(vertex);
      for (Vertex neighbor : vertex.neighbors) {
        recursiveDFS(neighbor);
      }
    }
  }

  /*
   * This implementation is more optimized than the above because it visits the currentVertex's
   * neighbors before actually iterating over them. This avoids adding duplicates to the Stack and
   * therefore is more optimized, but (IMHO) is conceptually weird since you are visiting a node
   * before actually iterate over it.
   */
  void iterativeDFSOptimized(Vertex vertex) {
    Stack<Vertex> stack = new Stack<>();

    // Visit vertex (mark + print)
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

  /*
   * Traditional recursive implementation for DFS found in books out there.
   */
  void traditionalRecursiveDFS(Vertex vertex) {
    System.out.print(vertex);
    vertex.visited = true;

    for (Vertex neighbor : vertex.neighbors) {
      if (neighbor.visited == false) {
        traditionalRecursiveDFS(neighbor);
      }
    }
  }
}
