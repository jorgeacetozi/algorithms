package com.jorgeacetozi.algorithms.stack.dynamicArray;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.EmptyStackException;
import org.junit.Test;
import com.jorgeacetozi.algorithms.stack.dynamicArray.DynamicArrayStack;

public class DynamicArrayStackTest {
  DynamicArrayStack<String> stack = new DynamicArrayStack<>(3);

  @Test
  public void shouldPushItemsIntoStack() {
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");
    assertThat(stack.size, equalTo(3));
  }

  @Test
  public void shouldResizeWhenStackIsFull() {
    assertThat(stack.size, equalTo(0));
    assertThat(stack.capacity, equalTo(3));
    stack.push("jorge");
    stack.push("xuxa");
    stack.push("cobra");
    assertThat(stack.size, equalTo(3));
    assertThat(stack.capacity, equalTo(6));
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

  @Test(expected = EmptyStackException.class)
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
