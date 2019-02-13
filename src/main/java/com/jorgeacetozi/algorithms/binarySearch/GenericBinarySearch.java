package com.jorgeacetozi.algorithms.binarySearch;

class GenericBinarySearch<T extends Comparable<T>> {

  T[] array;

  boolean binarySearch(T[] array, T target) {
    this.array = array;
    return this.binarySearch(0, array.length - 1, array, target);
  }

  // O(logN)
  private boolean binarySearch(int start, int end, T[] array, T target) {
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
}
