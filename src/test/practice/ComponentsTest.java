package practice;

import graph.AdjacencyListGraph;
import graph.Graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for counting the connected components of an undirected graph. */
public class ComponentsTest {

  @Test
  public void emptyGraphHasNoComponents() {
    assertEquals(0, Components.countComponents(new AdjacencyListGraph<Integer>()));
  }

  @Test
  public void loneVertexIsOneComponent() {
    assertEquals(1, Components.countComponents(vertices(1)));
  }

  @Test
  public void verticesWithNoEdgesAreEachAComponent() {
    assertEquals(3, Components.countComponents(vertices(3)));
  }

  @Test
  public void connectedGraphIsOneComponent() {
    Graph<Integer> graph = vertices(3);
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    assertEquals(1, Components.countComponents(graph));
  }

  @Test
  public void graphWithACycleIsOneComponent() {
    Graph<Integer> graph = vertices(3);
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    addUndirected(graph, 2, 0);
    assertEquals(1, Components.countComponents(graph));
  }

  @Test
  public void separatePiecesAreCountedOnceEach() {
    // A triangle 0, 1, 2, an edge 3-4, and the lone vertices 5 and 6.
    Graph<Integer> graph = vertices(7);
    addUndirected(graph, 0, 1);
    addUndirected(graph, 1, 2);
    addUndirected(graph, 2, 0);
    addUndirected(graph, 3, 4);
    assertEquals(4, Components.countComponents(graph));
  }

  // A graph with the vertices 0 through count - 1 and no edges.
  private Graph<Integer> vertices(int count) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex < count; vertex++) {
      graph.addVertex(vertex);
    }
    return graph;
  }

  private void addUndirected(Graph<Integer> graph, int first, int second) {
    graph.addEdge(first, second);
    graph.addEdge(second, first);
  }
}
