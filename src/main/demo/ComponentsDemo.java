package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import practice.Components;

/** A demo of Components on the notes' first example: seven vertices in three groups. */
public final class ComponentsDemo {

  private ComponentsDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex <= 6; vertex++) {
      graph.addVertex(vertex);
    }
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    addUndirected(graph, 3, 4);
    addUndirected(graph, 5, 6);
    System.out.println("vertices: 0 to 6");
    System.out.println("edges: 0-1, 1-2, 3-4, 5-6");

    // The groups are {0, 1, 2}, {3, 4}, and {5, 6}. Expect 3.
    int count = Components.countComponents(graph);
    System.out.println("components: " + count);
  }

  // Adds an undirected edge as a directed edge in each direction.
  private static void addUndirected(Graph<Integer> graph, int first, int second) {
    graph.addEdge(first, second);
    graph.addEdge(second, first);
  }
}
