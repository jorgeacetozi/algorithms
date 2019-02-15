package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Optional;
import org.junit.Test;

public class LRUTestCache {

  private LRUCache<String, Integer> cache = new LRUCache<>(3);

  @Test
  public void shouldUpdateCacheItemWhenThereIsOnlyOneItemInIt() {
    cache.put("jorge", 1);
    cache.put("jorge", 2);

    Optional<Integer> optional = cache.get("jorge");

    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(2));
  }

  @Test
  public void shouldUpdateCacheItemWhenThereAreTwoItemsInIt() {
    cache.put("jorge1", 1);
    cache.put("jorge2", 2);
    assertThat(cache.getSize(), equalTo(2));
    assertThat(cache.getLRUKeys().get(0), equalTo("jorge2"));
    assertThat(cache.getLRUKeys().get(1), equalTo("jorge1"));
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge1"));

    cache.put("jorge2", 3);
    assertThat(cache.getSize(), equalTo(2));
    assertThat(cache.getLRUKeys().get(0), equalTo("jorge2"));
    assertThat(cache.getLRUKeys().get(1), equalTo("jorge1"));
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge1"));

    Optional<Integer> optional = cache.get("jorge2");
    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(3));
  }

  @Test
  public void shouldUpdateCacheItemWhenItIsFull() {
    cache.put("jorge1", 1);
    cache.put("jorge2", 2);
    cache.put("jorge3", 3);
    assertThat(cache.getSize(), equalTo(3));
    assertThat(cache.getLRUKeys().get(0), equalTo("jorge3"));
    assertThat(cache.getLRUKeys().get(1), equalTo("jorge2"));
    assertThat(cache.getLRUKeys().get(2), equalTo("jorge1"));
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge1"));

    cache.put("jorge3", 4);
    assertThat(cache.getSize(), equalTo(3));
    assertThat(cache.getLRUKeys().get(0), equalTo("jorge3"));
    assertThat(cache.getLRUKeys().get(1), equalTo("jorge2"));
    assertThat(cache.getLRUKeys().get(2), equalTo("jorge1"));
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge1"));

    Optional<Integer> optional = cache.get("jorge3");
    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(4));
  }

  @Test
  public void shouldEvictLeastRecentlyUsedItemWhenPuttingNewItemAndTheCacheIsFull() {
    cache.put("jorge1", 1);
    cache.put("jorge2", 2);
    cache.put("jorge3", 3);
    assertThat(cache.getSize(), equalTo(3));
    assertTrue(cache.isFull());
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge1"));

    cache.put("dog", 10);
    Optional<Integer> optional = cache.get("jorge1");
    assertFalse(optional.isPresent());
    assertThat(cache.getLRUKeys().get(0), equalTo("dog"));
    assertThat(cache.getLRUKeys().get(1), equalTo("jorge3"));
    assertThat(cache.getLRUKeys().get(2), equalTo("jorge2"));
    assertThat(cache.getNextKeyToBeEvicted(), equalTo("jorge2"));
  }
}
