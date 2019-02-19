package com.jorgeacetozi.algorithms.sorting.heapSort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.jorgeacetozi.algorithms.sorting.Person;

public class HeapSortTest {

  @Test
  public void shouldSortListOfIntegers() {
    HeapSort<Integer> heapSort = new HeapSort<>(5);
    List<Integer> input = Arrays.asList(5, 1, 10, -5, 55);
    List<Integer> sortedList = heapSort.sort(input);

    assertThat(sortedList.get(0), equalTo(-5));
    assertThat(sortedList.get(1), equalTo(1));
    assertThat(sortedList.get(2), equalTo(5));
    assertThat(sortedList.get(3), equalTo(10));
    assertThat(sortedList.get(4), equalTo(55));
  }

  @Test
  public void shouldSortListOfPersonByAge() {
    HeapSort<Person> heapSort = new HeapSort<>(5);

    Person jorge = new Person("Jorge", 30);
    Person cobra = new Person("Cobra", 5);
    Person xuxinha = new Person("Xuxinha", 50);
    Person alex = new Person("Alex", 35);
    Person ju = new Person("Ju", 10);

    List<Person> input = Arrays.asList(jorge, cobra, xuxinha, alex, ju);

    List<Person> sortedList = heapSort.sort(input);

    assertThat(sortedList.get(0), equalTo(cobra));
    assertThat(sortedList.get(1), equalTo(ju));
    assertThat(sortedList.get(2), equalTo(jorge));
    assertThat(sortedList.get(3), equalTo(alex));
    assertThat(sortedList.get(4), equalTo(xuxinha));
  }
}
