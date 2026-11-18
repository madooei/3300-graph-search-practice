# Graph Search — Practice

Two practice problems on graph search: decide whether an undirected graph has a cycle, and split the vertices of an undirected graph into two teams so that no edge joins two vertices on the same team. Each problem takes a `Graph<V>` and has a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      graph/
        Graph.java                    # unchanged copy of the Graph ADT
        AdjacencyListGraph.java       # unchanged copy of the graph chapter's implementation
      set/
        Set.java                      # unchanged copy of the course Set ADT
        HashSet.java                  # a set backed by the course HashMap
      map/
        Map.java                      # unchanged copy of the course Map ADT
        HashMap.java                  # unchanged copy of the course hash table
      queue/
        Queue.java                    # unchanged copy of the course Queue ADT
        LinkedQueue.java              # unchanged copy of the course linked queue
      practice/
        UndirectedCycle.java          # cycle in an undirected graph
        TwoTeams.java                 # two teams, with a breadth-first search
    test/
      practice/
        UndirectedCycleTest.java
        TwoTeamsTest.java
  scripts/
    test.sh                           # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.TwoTeamsTest` — compiles everything and runs only that test class.

## What's here

- `practice.UndirectedCycle` — `hasCycle`, a depth-first search that skips the vertex it came from.
- `practice.TwoTeams` — `hasTwoTeams`, a breadth-first search that gives each vertex the other team from the vertex it was reached from.
- `practice.UndirectedCycleTest` and `practice.TwoTeamsTest` — one suite per problem.
- `graph.Graph<V>` and `graph.AdjacencyListGraph<V>` — unchanged copies of the graph chapter's classes. Both problems take a `Graph`.
- `set.Set<T>` and `set.HashSet<T>` — the same visited set as the chapter's code: a `Set` whose elements are the keys of a course `HashMap`. `hasCycle` keeps its visited vertices in one.
- `map.Map<K, V>` and `map.HashMap<K, V>` — unchanged copies of the course's map, which `AdjacencyListGraph` and `HashSet` are built on. `hasTwoTeams` keeps each vertex's team in one.
- `queue.Queue<T>` and `queue.LinkedQueue<T>` — unchanged copies of the course's queue. `hasTwoTeams` keeps the vertices still to visit in one.
