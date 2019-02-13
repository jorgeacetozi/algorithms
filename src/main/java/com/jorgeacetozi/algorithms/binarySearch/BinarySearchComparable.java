package com.jorgeacetozi.algorithms.binarySearch;

class BinarySearchComparable<T> {

  boolean binarySearch(Comparable<T>[] array, T target) {
    return this.binarySearch(0, array.length - 1, array, target);
  }

  private boolean binarySearch(int start, int end, Comparable<T>[] array, T target) {
    if (start > end) {
      return false;
    }

    int middle = (start + end) / 2;

    if (array[middle].compareTo(target) == 0) {
      return true;
    } else if (array[middle].compareTo(target) < 0) {
      return binarySearch(middle + 1, end, array, target);
    } else {
      return binarySearch(start, middle - 1, array, target);
    }
  }

  public static void main(String[] args) {
    BinarySearchComparable<String> binarySearch = new BinarySearchComparable<>();
    String[] array = {"alex", "bruna", "carol", "daniel"};
    System.out.println(binarySearch.binarySearch(array, "Bruna"));

    // BinarySearch<Person> binarySearchPerson = new BinarySearch<>();
    // Person[] persons = {new Person("jorge", 31), new Person("bruna", 17)};
    // System.out.println(binarySearchPerson.binarySearch(persons, new Person("jorge", 11)));
  }

}
