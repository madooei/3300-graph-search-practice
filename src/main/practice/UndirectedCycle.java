package practice;

import graph.Graph;
import set.Set;

/** Practice problem: decide whether an undirected graph has a cycle. */
public final class UndirectedCycle {

  private UndirectedCycle() {
    // This class should not be instantiated!
  }

  // Returns true if graph has a cycle. Assumes graph is not null and is
  // undirected: every edge from a to b has a matching edge from b to a.
  public static <V> boolean hasCycle(Graph<V> graph) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Searches from v, which was reached from parent, and returns true if the
  // search finds a cycle. The parent is null for the vertex a search starts from.
  private static <V> boolean search(Graph<V> graph, V v, V parent, Set<V> visited) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
