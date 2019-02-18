package com.jorgeacetozi.algorithms.stack.simpleStaticArray;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SimpleStaticArrayStackTest {

  SimpleStaticArrayStack<String> stack = new SimpleStaticArrayStack<>(3);

  @Test
  public void shouldPushItemsIntoStack() {
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");
    assertThat(stack.size, equalTo(3));
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenPushingItemsIntoFullStack() {
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");
    stack.push("sorry, stack is full");
  }

  @Test
  public void shouldGetItemsFromStack() {
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");

    assertThat(stack.pop(), equalTo("cobra"));
    assertThat(stack.pop(), equalTo("xuxa"));
    assertThat(stack.pop(), equalTo("jorge"));
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenPoppingAnEmptyStack() {
    stack.pop();
  }

  @Test
  public void shouldReturnPeekItem() {
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");

    assertThat(stack.peek(), equalTo("cobra"));
    stack.pop();
    assertThat(stack.peek(), equalTo("xuxa"));
    stack.pop();
    assertThat(stack.peek(), equalTo("jorge"));
  }
  
  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenReturningPeekItemFromEmptyList() {
    stack.peek();
  }
}
