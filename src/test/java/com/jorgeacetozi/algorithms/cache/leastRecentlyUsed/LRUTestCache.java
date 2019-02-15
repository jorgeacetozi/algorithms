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
    
    cache.put("jorge2", 3);
    assertThat(cache.getSize(), equalTo(2));
    
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
    
    cache.put("jorge3", 4);
    assertThat(cache.getSize(), equalTo(3));
    
    Optional<Integer> optional = cache.get("jorge3");
    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(4));
  }
}
