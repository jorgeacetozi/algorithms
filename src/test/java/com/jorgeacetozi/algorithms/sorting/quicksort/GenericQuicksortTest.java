package com.jorgeacetozi.algorithms.sorting.quicksort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.jorgeacetozi.algorithms.sorting.Person;

public class GenericQuicksortTest {

  GenericQuicksort quicksort = new GenericQuicksort();

  @Test
  public void shouldSortIntArray() {
    Integer[] array = {5, 1, 3, -5, 2, -2};

    quicksort.quicksort(array);

    assertThat(array[0], equalTo(-5));
    assertThat(array[1], equalTo(-2));
    assertThat(array[2], equalTo(1));
    assertThat(array[3], equalTo(2));
    assertThat(array[4], equalTo(3));
    assertThat(array[5], equalTo(5));
  }
  
  @Test
  public void shouldSortListOfPersonByAge() {
    Person jorge = new Person("Jorge", 30);
    Person cobra = new Person("Cobra", 5);
    Person xuxinha = new Person("Xuxinha", 50);
    Person alex = new Person("Alex", 35);
    Person ju = new Person("Ju", 10);

    Person[] input = {jorge, cobra, xuxinha, alex, ju};

    quicksort.quicksort(input);

    assertThat(input[0], equalTo(cobra));
    assertThat(input[1], equalTo(ju));
    assertThat(input[2], equalTo(jorge));
    assertThat(input[3], equalTo(alex));
    assertThat(input[4], equalTo(xuxinha));
  }
}
