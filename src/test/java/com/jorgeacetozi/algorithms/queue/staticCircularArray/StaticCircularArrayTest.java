package com.jorgeacetozi.algorithms.queue.staticCircularArray;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;
import com.jorgeacetozi.algorithms.queue.staticCircularArray.StaticCircularArray;

public class StaticCircularArrayTest {

  StaticCircularArray<String> circularArray = new StaticCircularArray<>(3);

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenRetrievingItemFromEmptyArray() {
    circularArray.removeStart();
  }

  @Test
  public void shouldInsertIntoCircularArray() {
    circularArray.insertEnd("jorge");
    circularArray.insertEnd("cobra");
    circularArray.insertEnd("xuxa");
    assertThat(circularArray.size, equalTo(circularArray.capacity));
  }

  @Test
  public void shouldRemoveFromCircularArray() {
    circularArray.insertEnd("jorge");
    circularArray.insertEnd("cobra");
    circularArray.insertEnd("xuxa");
    assertThat(circularArray.size, equalTo(circularArray.capacity));
    assertThat(circularArray.size, equalTo(3));

    String firstItemInserted = circularArray.removeStart();
    assertThat(firstItemInserted, equalTo("jorge"));
    assertThat(circularArray.size, equalTo(2));

    String secondItemInserted = circularArray.removeStart();
    assertThat(secondItemInserted, equalTo("cobra"));
    assertThat(circularArray.size, equalTo(1));

    String thirdItemInserted = circularArray.removeStart();
    assertThat(thirdItemInserted, equalTo("xuxa"));
    assertThat(circularArray.size, equalTo(0));
  }

  @Test
  public void shouldCircularlyInsertAndRemoveItems() {
    circularArray.insertEnd("jorge");
    circularArray.insertEnd("cobra");
    circularArray.insertEnd("xuxa");
    circularArray.removeStart();
    circularArray.insertEnd("navalha");
    assertTrue(circularArray.get(0).isPresent());
    assertThat(circularArray.get(0).get(), equalTo("navalha"));
    assertThat(circularArray.size, equalTo(3));
  }
}
