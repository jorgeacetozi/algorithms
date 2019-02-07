package com.jorgeacetozi.algorithms.singlyLinkedList;

class Node {
  int value;
  Node next;
  
  Node(int value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + value;
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
    Node other = (Node) obj;
    if (value != other.value)
      return false;
    return true;
  }
}
