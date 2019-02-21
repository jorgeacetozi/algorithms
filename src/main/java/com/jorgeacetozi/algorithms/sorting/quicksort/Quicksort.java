package com.jorgeacetozi.algorithms.sorting.quicksort;

class Quicksort {

  void quicksort(int[] array) {
    quicksort(0, array.length - 1, array);
  }

  private void quicksort(int low, int high, int[] array) {
    if (low < high) { // we keep running quicksort as long as low < high
      int pivotIndex = partition(low, high, array);
      quicksort(low, pivotIndex - 1, array);
      quicksort(pivotIndex + 1, high, array);
    }
  }

  private int partition(int low, int high, int[] array) {
    int pivotIndex = (low + high) / 2; // choose middle item to be the pivot
    swap(pivotIndex, high, array); // move the pivot to the last item of the array

    int i = low;
    for (int j = low; j < high; j++) {
      if (array[j] <= array[high]) { // if we find an item smaller than the pivot, insert it in
                                     // position i by swapping with the item in position j
        swap(j, i, array);
        i++;
      }
    }

    swap(high, i, array); // move the pivot to its correct final position in the array
    return i; // and return this position so quicksort can recursively sort the sub arrays
  }

  private void swap(int current, int target, int[] array) {
    int temp = array[target];
    array[target] = array[current];
    array[current] = temp;
  }
}
