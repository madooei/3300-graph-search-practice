package practice;

import graph.Graph;
import set.HashSet;
import set.Set;

/** Practice problem: decide whether an undirected graph has a cycle. */
public final class UndirectedCycle {

  private UndirectedCycle() {
    // This class should not be instantiated!
  }

  // Returns true if graph has a cycle. Assumes graph is not null and is
  // undirected: every edge from a to b has a matching edge from b to a.
  public static <V> boolean hasCycle(Graph<V> graph) {
    Set<V> visited = new HashSet<>();

    for (V v : graph.vertices()) {
      if (!visited.contains(v) && search(graph, v, null, visited)) {
        return true;
      }
    }
    return false;
  }

  // Searches from v, which was reached from parent, and returns true if the
  // search finds a cycle. The parent is null for the vertex a search starts from.
  private static <V> boolean search(Graph<V> graph, V v, V parent, Set<V> visited) {
    visited.add(v);

    for (V neighbor : graph.neighbors(v)) {
      if (neighbor.equals(parent)) {
        continue;  // the edge we came in on, not a second route
      }
      if (visited.contains(neighbor)) {
        return true;  // a second route into a vertex we have already seen
      }
      if (search(graph, neighbor, v, visited)) {
        return true;
      }
    }
    return false;
  }
}
