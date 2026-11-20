package practice;

import graph.AdjacencyListGraph;
import graph.Graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for deciding whether an undirected graph has a cycle. */
public class UndirectedCycleTest {

  // Builds an undirected graph on the vertices 0 through vertexCount - 1,
  // adding each edge {a, b} in both directions.
  private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex < vertexCount; vertex++) {
      graph.addVertex(vertex);
    }
    for (int[] edge : edges) {
      graph.addEdge(edge[0], edge[1]);
      graph.addEdge(edge[1], edge[0]);
    }
    return graph;
  }

  @Test
  public void emptyGraphIsNotACycle() {
    assertFalse(UndirectedCycle.hasCycle(new AdjacencyListGraph<Integer>()));
  }

  @Test
  public void noEdgesIsNotACycle() {
    int[][] edges = {};
    assertFalse(UndirectedCycle.hasCycle(undirected(5, edges)));
  }

  @Test
  public void oneEdgeIsNotACycle() {
    int[][] edges = {{0, 1}};
    assertFalse(UndirectedCycle.hasCycle(undirected(2, edges)));
  }

  @Test
  public void chainIsNotACycle() {
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
    assertFalse(UndirectedCycle.hasCycle(undirected(4, edges)));
  }

  @Test
  public void treeIsNotACycle() {
    int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
    assertFalse(UndirectedCycle.hasCycle(undirected(5, edges)));
  }

  @Test
  public void triangleIsACycle() {
    int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
    assertTrue(UndirectedCycle.hasCycle(undirected(3, edges)));
  }

  @Test
  public void cycleAtTheEndOfAPathIsFound() {
    // The search from 0 finds the cycle 1, 2, 3 two calls deep.
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
    assertTrue(UndirectedCycle.hasCycle(undirected(4, edges)));
  }

  @Test
  public void chapterGraphHasACycle() {
    int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {3, 5}, {4, 6}, {5, 6}};
    assertTrue(UndirectedCycle.hasCycle(undirected(7, edges)));
  }

  @Test
  public void cycleInASecondComponentIsFound() {
    int[][] edges = {{0, 1}, {2, 3}, {3, 4}, {4, 2}};
    assertTrue(UndirectedCycle.hasCycle(undirected(5, edges)));
  }

  @Test
  public void stringVerticesWork() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("Albany");
    graph.addVertex("Boston");
    graph.addEdge("Albany", "Boston");
    graph.addEdge("Boston", "Albany");
    assertFalse(UndirectedCycle.hasCycle(graph));
  }
}
