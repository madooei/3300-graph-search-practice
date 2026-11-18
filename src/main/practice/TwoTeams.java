package practice;

import graph.Graph;
import map.Map;

/** Practice problem: split the vertices of an undirected graph into two teams. */
public final class TwoTeams {

  private static final int TEAM_A = 0;
  private static final int TEAM_B = 1;

  private TwoTeams() {
    // This class should not be instantiated!
  }

  // Returns true if the vertices of graph can be put on two teams so that no
  // edge joins two vertices on the same team. Assumes graph is not null and is
  // undirected: every edge from a to b has a matching edge from b to a.
  public static <V> boolean hasTwoTeams(Graph<V> graph) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Searches from start, putting start on team A and every vertex reached on
  // the other team from the vertex it was reached from. Returns false if some
  // edge joins two vertices on the same team.
  private static <V> boolean canSplit(Graph<V> graph, V start, Map<V, Integer> team) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
