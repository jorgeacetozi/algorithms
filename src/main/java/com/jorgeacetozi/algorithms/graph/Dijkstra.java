package com.jorgeacetozi.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Vertex {
  String name;
  Integer minDistance;
  Vertex predecessor;
  List<Edge> adjacenceList;

  public Vertex(String name) {
    this.name = name;
    this.adjacenceList = new ArrayList<>();
  }

  @Override
  public String toString() {
    return this.name + " " + minDistance;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vertex other = (Vertex) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}


class Edge {
  Vertex from;
  Vertex to;
  Integer weight;

  public Edge(Vertex from, Vertex to, Integer weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}


class Dijkstra {

  List<Vertex> dijkstra(List<Vertex> vertexList, Vertex source) {
    // init phase
    PriorityQueue<Vertex> heap = new PriorityQueue<>(Comparator.comparingInt(v -> v.minDistance));
    for (Vertex vertex : vertexList) {
      if (vertex.equals(source)) {
        vertex.minDistance = 0;
      } else {
        vertex.minDistance = Integer.MAX_VALUE;
      }
      heap.add(vertex);
    }

    while (!heap.isEmpty()) {
      Vertex currentVertex = heap.poll();

      // relaxing edges phase
      for (Edge edge : currentVertex.adjacenceList) {
        Vertex neighborVertex = edge.to;

        if (currentVertex.minDistance + edge.weight < neighborVertex.minDistance) {
          heap.remove(neighborVertex); // takes O(N)
          neighborVertex.minDistance = currentVertex.minDistance + edge.weight;
          neighborVertex.predecessor = currentVertex;
          heap.add(neighborVertex); // takes O(logN)
        }
      }
    }
    return vertexList;
  }

  void printShortestPathTo(Vertex vertex) {
    if (vertex == null) {
      return;
    }
    printShortestPathTo(vertex.predecessor);
    System.out.print(vertex.name + " -> ");
  }

  public static void main(String[] args) {
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Vertex vertexF = new Vertex("F");
    Vertex vertexG = new Vertex("G");
    Vertex vertexH = new Vertex("H");

    Edge edgeAB = new Edge(vertexA, vertexB, 5);
    Edge edgeAH = new Edge(vertexA, vertexH, 8);
    Edge edgeAE = new Edge(vertexA, vertexE, 9);
    vertexA.adjacenceList.addAll(Arrays.asList(edgeAB, edgeAH, edgeAE));

    Edge edgeBH = new Edge(vertexB, vertexH, 4);
    Edge edgeBC = new Edge(vertexB, vertexC, 12);
    Edge edgeBD = new Edge(vertexB, vertexD, 15);
    vertexB.adjacenceList.addAll(Arrays.asList(edgeBH, edgeBC, edgeBD));

    Edge edgeCD = new Edge(vertexC, vertexD, 3);
    Edge edgeCG = new Edge(vertexC, vertexG, 11);
    vertexC.adjacenceList.addAll(Arrays.asList(edgeCD, edgeCG));

    Edge edgeDG = new Edge(vertexD, vertexG, 9);
    vertexD.adjacenceList.add(edgeDG);

    Edge edgeEH = new Edge(vertexE, vertexH, 5);
    Edge edgeEF = new Edge(vertexE, vertexF, 4);
    Edge edgeEG = new Edge(vertexE, vertexG, 20);
    vertexE.adjacenceList.addAll(Arrays.asList(edgeEG, edgeEF, edgeEH));

    Edge edgeFC = new Edge(vertexF, vertexC, 1);
    Edge edgeFG = new Edge(vertexF, vertexG, 13);
    vertexF.adjacenceList.addAll(Arrays.asList(edgeFC, edgeFG));

    Edge edgeHC = new Edge(vertexH, vertexC, 7);
    Edge edgeHF = new Edge(vertexH, vertexF, 6);
    vertexH.adjacenceList.addAll(Arrays.asList(edgeHC, edgeHF));

    List<Vertex> vertexList =
        Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH);

    List<Vertex> shortestPathsFromVertexA =
        new Dijkstra().dijkstra(vertexList, vertexList.get(vertexList.indexOf(new Vertex("A"))));

    System.out.println(shortestPathsFromVertexA);

    new Dijkstra().printShortestPathTo(
        shortestPathsFromVertexA.get(shortestPathsFromVertexA.indexOf(new Vertex("G"))));
  }
}

