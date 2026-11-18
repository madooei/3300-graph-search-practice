package practice;

import graph.AdjacencyListGraph;
import graph.Graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for splitting the vertices of an undirected graph into two teams. */
public class TwoTeamsTest {

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
  public void emptyGraphSplits() {
    assertTrue(TwoTeams.hasTwoTeams(new AdjacencyListGraph<Integer>()));
  }

  @Test
  public void noEdgesSplits() {
    int[][] edges = {};
    assertTrue(TwoTeams.hasTwoTeams(undirected(5, edges)));
  }

  @Test
  public void oneEdgeSplits() {
    int[][] edges = {{0, 1}};
    assertTrue(TwoTeams.hasTwoTeams(undirected(2, edges)));
  }

  @Test
  public void treeSplits() {
    int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
    assertTrue(TwoTeams.hasTwoTeams(undirected(5, edges)));
  }

  @Test
  public void squareSplits() {
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
    assertTrue(TwoTeams.hasTwoTeams(undirected(4, edges)));
  }

  @Test
  public void triangleDoesNotSplit() {
    int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
    assertFalse(TwoTeams.hasTwoTeams(undirected(3, edges)));
  }

  @Test
  public void chapterGraphSplits() {
    int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {3, 5}, {4, 6}, {5, 6}};
    assertTrue(TwoTeams.hasTwoTeams(undirected(7, edges)));
  }

  @Test
  public void oddCycleInASecondComponentDoesNotSplit() {
    int[][] edges = {{0, 1}, {2, 3}, {3, 4}, {4, 2}};
    assertFalse(TwoTeams.hasTwoTeams(undirected(5, edges)));
  }

  @Test
  public void stringVerticesWork() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("Albany");
    graph.addVertex("Boston");
    graph.addEdge("Albany", "Boston");
    graph.addEdge("Boston", "Albany");
    assertTrue(TwoTeams.hasTwoTeams(graph));
  }
}
