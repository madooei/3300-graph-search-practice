package practice;

import graph.Graph;
import set.HashSet;
import set.Set;
import stack.ArrayStack;
import stack.Stack;

/** Practice problem: count the connected components of an undirected graph. */
public final class Components {

  private Components() {
    // This class should not be instantiated!
  }

  // Returns the number of connected components of graph. Assumes graph is not
  // null and is undirected, with each edge stored in both directions.
  public static <V> int countComponents(Graph<V> graph) {
    Set<V> visited = new HashSet<>();
    int count = 0;

    for (V v : graph.vertices()) {
      if (!visited.contains(v)) {
        count++;
        search(graph, v, visited);
      }
    }
    return count;
  }

  // Adds to visited every vertex reachable from start that is not already in it.
  private static <V> void search(Graph<V> graph, V start, Set<V> visited) {
    Stack<V> toProcess = new ArrayStack<>();
    visited.add(start);
    toProcess.push(start);
    while (!toProcess.isEmpty()) {
      V v = toProcess.top();
      toProcess.pop();
      for (V neighbor : graph.neighbors(v)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          toProcess.push(neighbor);
        }
      }
    }
  }
}
