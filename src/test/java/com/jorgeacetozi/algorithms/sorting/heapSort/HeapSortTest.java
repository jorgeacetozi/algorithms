package com.jorgeacetozi.algorithms.sorting.heapsort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.jorgeacetozi.algorithms.sorting.Person;
import com.jorgeacetozi.algorithms.sorting.heapsort.Heapsort;

public class HeapsortTest {

  Heapsort sort = new Heapsort();

  @Test
  public void shouldSortListOfIntegers() {
    List<Integer> list = new ArrayList<>(Arrays.asList(5, 1, 10, -5, 55));

    sort.heapsort(list);

    assertThat(list.get(0), equalTo(-5));
    assertThat(list.get(1), equalTo(1));
    assertThat(list.get(2), equalTo(5));
    assertThat(list.get(3), equalTo(10));
    assertThat(list.get(4), equalTo(55));
  }

  @Test
  public void shouldSortListOfPersonByAge() {
    Person jorge = new Person("Jorge", 30);
    Person cobra = new Person("Cobra", 5);
    Person xuxinha = new Person("Xuxinha", 50);
    Person alex = new Person("Alex", 35);
    Person ju = new Person("Ju", 10);

    List<Person> list = new ArrayList<>(Arrays.asList(jorge, cobra, xuxinha, alex, ju));

    sort.heapsort(list);

    assertThat(list.get(0), equalTo(cobra));
    assertThat(list.get(1), equalTo(ju));
    assertThat(list.get(2), equalTo(jorge));
    assertThat(list.get(3), equalTo(alex));
    assertThat(list.get(4), equalTo(xuxinha));
  }
}
