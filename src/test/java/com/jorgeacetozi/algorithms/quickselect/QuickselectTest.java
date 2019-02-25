package com.jorgeacetozi.algorithms.quickselect;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class QuickselectTest {

  Quickselect quickselect = new Quickselect();
  int[] array = {10, 2, 19, -5, 0, 5, 25, 8};

  @Test
  public void shouldFindFirstStatisticOrder() { // assuming 1st statistic order is the min item
    assertThat(quickselect.quickselect(1, array), equalTo(-5));
  }

  @Test
  public void shouldFindThirdStatisticOrder() { // third smallest item in the list
    assertThat(quickselect.quickselect(3, array), equalTo(2));
  }
}
