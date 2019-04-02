package com.jorgeacetozi.algorithms.binarySearch;

class GenericBinarySearch<T extends Comparable<T>> {

  T[] array;

  boolean binarySearch(T[] array, T target) {
    this.array = array;
    return this.binarySearch(0, array.length - 1, array, target);
  }

  // O(logN)
  private boolean binarySearch(int start, int end, T[] array, T target) {
    if (start <= end) { // Unlike Quicksort, we have to consider the "equal" case, otherwise
                        // if the target is the last array item it will not be found
      int middle = (start + end) / 2;

      if (target.compareTo(array[middle]) < 0) {
        return binarySearch(start, middle - 1, array, target);
      } else if (target.compareTo(array[middle]) > 0) {
        return binarySearch(middle + 1, end, array, target);
      } else {
        return true;
      }
    }
    return false;
  }
}
