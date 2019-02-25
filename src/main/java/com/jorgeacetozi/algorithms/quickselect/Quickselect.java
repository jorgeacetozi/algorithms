package com.jorgeacetozi.algorithms.quickselect;

class Quickselect {

  int quickselect(int k, int[] array) {
    if (k > array.length || k < 0) {
      throw new RuntimeException("K is out of the array limits");
    }
    return quickselect(0, array.length - 1, k - 1, array);
  }

  private int quickselect(int low, int high, int k, int[] array) {
    int pivotIndex = partition(low, high, array);

    if (k < pivotIndex) {
      return quickselect(low, pivotIndex - 1, k, array);
    } else if (k > pivotIndex) {
      return quickselect(pivotIndex + 1, high, k, array);
    }

    return array[pivotIndex];
  }

  private int partition(int low, int high, int[] array) {
    int pivotIndex = (low + high) / 2;
    swap(pivotIndex, high, array);

    int i = low;
    for (int j = low; j < high; j++) {
      if (array[j] <= array[high]) {
        swap(j, i, array);
        i++;
      }
    }

    swap(high, i, array);
    return i;
  }

  private void swap(int currentPosition, int targetPosition, int[] array) {
    int temp = array[targetPosition];
    array[targetPosition] = array[currentPosition];
    array[currentPosition] = temp;
  }
}
