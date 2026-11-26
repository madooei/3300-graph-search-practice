package practice;

import graph.Graph;
import map.HashMap;
import map.Map;
import queue.LinkedQueue;
import queue.Queue;

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
    Map<V, Integer> team = new HashMap<>();

    for (V vertex : graph.vertices()) {
      if (!team.containsKey(vertex) && !search(graph, vertex, team)) {
        return false;
      }
    }
    return true;
  }

  // Searches from start, putting start on team A and every vertex reached on
  // the other team from the vertex it was reached from. Returns false if some
  // edge joins two vertices on the same team.
  private static <V> boolean search(Graph<V> graph, V start, Map<V, Integer> team) {
    Queue<V> toProcess = new LinkedQueue<>();

    team.put(start, TEAM_A);
    toProcess.enqueue(start);

    while (!toProcess.isEmpty()) {
      V vertex = toProcess.front();
      toProcess.dequeue();
      int theirs = TEAM_B;
      int mine = team.get(vertex);
      if (mine == TEAM_B) {
        theirs = TEAM_A;
      }

      for (V neighbor : graph.neighbors(vertex)) {
        if (!team.containsKey(neighbor)) {
          team.put(neighbor, theirs);
          toProcess.enqueue(neighbor);
        } else if (team.get(neighbor) == mine) {
          return false;  // an edge with both ends on the same team
        }
      }
    }
    return true;
  }
}
