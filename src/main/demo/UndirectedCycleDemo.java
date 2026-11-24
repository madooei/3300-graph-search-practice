package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import practice.UndirectedCycle;

/** A demo of UndirectedCycle on the notes' triangle example. */
public final class UndirectedCycleDemo {

  private UndirectedCycleDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex <= 2; vertex++) {
      graph.addVertex(vertex);
    }
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    addUndirected(graph, 2, 0);
    System.out.println("vertices: 0 to 2");
    System.out.println("edges: 0-1, 1-2, 2-0");

    // Go from 0 to 1 to 2, and the edge 2-0 leads back to 0. Expect true.
    boolean cycle = UndirectedCycle.hasCycle(graph);
    System.out.println("has a cycle: " + cycle);
  }

  // Adds an undirected edge as a directed edge in each direction.
  private static void addUndirected(Graph<Integer> graph, int first, int second) {
    graph.addEdge(first, second);
    graph.addEdge(second, first);
  }
}
