package com.jorgeacetozi.algorithms.binarySearch;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import org.junit.Test;

public class GenericBinarySearchTest {

  static class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public int compareTo(Person anotherPerson) {
      return this.name.compareTo(anotherPerson.name);
    }
  }

  @Test
  public void shouldFindPersonByName() {
    GenericBinarySearch<Person> search = new GenericBinarySearch<>();
    Person[] array = {new Person("jorge", 31), new Person("xuxa", 44)};
    assertTrue(search.binarySearch(array, new Person("jorge", 31)));
    System.out.println(search.array[0].getClass());
  }

  @Test
  public void shouldNotFindPersonByName() {
    GenericBinarySearch<Person> search = new GenericBinarySearch<>();
    Person[] array = {new Person("jorge", 31), new Person("xuxa", 44)};
    assertFalse(search.binarySearch(array, new Person("alex", 31)));
  }

  @Test
  public void shouldFindInteger() {
    GenericBinarySearch<Integer> search = new GenericBinarySearch<>();
    Integer[] array = {1, 4, 6, 7, 10};
    assertTrue(search.binarySearch(array, 10));
  }
}
