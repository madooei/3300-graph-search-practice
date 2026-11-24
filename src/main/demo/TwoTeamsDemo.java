package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import practice.TwoTeams;

/** A demo of TwoTeams on the notes' first example: a square. */
public final class TwoTeamsDemo {

  private TwoTeamsDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex <= 3; vertex++) {
      graph.addVertex(vertex);
    }
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    addUndirected(graph, 2, 3);
    addUndirected(graph, 3, 0);
    System.out.println("vertices: 0 to 3");
    System.out.println("edges: 0-1, 1-2, 2-3, 3-0");

    // Put 0 and 2 on one team and 1 and 3 on the other. Expect true.
    boolean split = TwoTeams.hasTwoTeams(graph);
    System.out.println("has two teams: " + split);
  }

  // Adds an undirected edge as a directed edge in each direction.
  private static void addUndirected(Graph<Integer> graph, int first, int second) {
    graph.addEdge(first, second);
    graph.addEdge(second, first);
  }
}
