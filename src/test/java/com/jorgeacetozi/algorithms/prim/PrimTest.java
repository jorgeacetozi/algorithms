package com.jorgeacetozi.algorithms.prim;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class PrimTest {

  Prim prim = new Prim();

  @Test
  public void shouldReturnMinimumSpanningTree() {
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    Vertex f = new Vertex("F");

    Edge ab = new Edge(a, b, 1);
    Edge ac = new Edge(a, c, 8);

    Edge ba = new Edge(b, a, 1);
    Edge bc = new Edge(b, c, 6);
    Edge bd = new Edge(b, d, 9);

    Edge ca = new Edge(c, a, 8);
    Edge cb = new Edge(c, b, 6);
    Edge cd = new Edge(c, d, 5);
    Edge ce = new Edge(c, e, 4);

    Edge db = new Edge(d, b, 9);
    Edge dc = new Edge(d, c, 5);
    Edge de = new Edge(d, e, 1);
    Edge df = new Edge(d, f, 3);

    Edge ec = new Edge(e, c, 4);
    Edge ed = new Edge(e, d, 1);
    Edge ef = new Edge(e, f, 2);

    Edge fd = new Edge(f, d, 3);
    Edge fe = new Edge(f, e, 2);

    a.edges.addAll(Arrays.asList(ab, ac));
    b.edges.addAll(Arrays.asList(ba, bc, bd));
    c.edges.addAll(Arrays.asList(ca, cb, cd, ce));
    d.edges.addAll(Arrays.asList(db, dc, de, df));
    e.edges.addAll(Arrays.asList(ec, ed, ef));
    f.edges.addAll(Arrays.asList(fd, fe));

    List<Vertex> vertices = Arrays.asList(a, b, c, d, e, f);
    List<Vertex> minimumSpanningTree = prim.minimumSpanningTree(vertices);

    assertThat(minimumSpanningTree.stream().map(v -> v.minWeight)
        .collect(Collectors.summingInt(minWeight -> minWeight)), is(14));
  }
}
