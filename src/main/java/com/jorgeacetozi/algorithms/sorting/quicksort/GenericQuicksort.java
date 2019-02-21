package com.jorgeacetozi.algorithms.sorting.quicksort;

class GenericQuicksort {

  <T extends Comparable<? super T>> void quicksort(T[] array) {
    quicksort(0, array.length - 1, array);
  }

  private <T extends Comparable<? super T>> void quicksort(int low, int high, T[] array) {
    if (low < high) {
      int pivotIndex = partition(low, high, array);
      quicksort(low, pivotIndex - 1, array);
      quicksort(pivotIndex + 1, high, array);
    }
  }

  private <T extends Comparable<? super T>> int partition(int low, int high, T[] array) {
    int pivotIndex = (low + high) / 2;
    swap(pivotIndex, high, array);

    int i = low;
    for (int j = low; j < high; j++) {
      if (array[j].compareTo(array[high]) <= 0) {
        swap(j, i, array);
        i++;
      }
    }

    swap(high, i, array);
    return i;
  }

  private <T extends Comparable<? super T>> void swap(int currentPosition, int targetIndex,
      T[] array) {
    T temp = array[targetIndex];
    array[targetIndex] = array[currentPosition];
    array[currentPosition] = temp;
  }
}
