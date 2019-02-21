package com.jorgeacetozi.algorithms.sorting.quicksort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.jorgeacetozi.algorithms.sorting.quicksort.Quicksort;

public class QuicksortTest {

  Quicksort quicksort = new Quicksort();

  @Test
  public void shouldSortIntArrayUsingQuicksort() {
    int[] array = {5, 1, 3, -5, 2, -2};

    quicksort.quicksort(array);

    assertThat(array[0], equalTo(-5));
    assertThat(array[1], equalTo(-2));
    assertThat(array[2], equalTo(1));
    assertThat(array[3], equalTo(2));
    assertThat(array[4], equalTo(3));
    assertThat(array[5], equalTo(5));
  }
}
