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

    for (V vertex : graph.vertices()) {
      if (!visited.contains(vertex) && search(graph, vertex, null, visited)) {
        return true;
      }
    }
    return false;
  }

  // Searches from vertex, which was reached from parent, and returns true if the
  // search finds a cycle. The parent is null for the vertex a search starts from.
  private static <V> boolean search(Graph<V> graph, V vertex, V parent, Set<V> visited) {
    visited.add(vertex);

    for (V neighbor : graph.neighbors(vertex)) {
      if (neighbor.equals(parent)) {
        continue;  // the edge we came in on, not a second route
      }
      if (visited.contains(neighbor)) {
        return true;  // a second route into a vertex we have already seen
      }
      if (search(graph, neighbor, vertex, visited)) {
        return true;
      }
    }
    return false;
  }
}
