# Graph Search — Practice

Three practice problems on graph search: count the connected components of an undirected graph, decide whether an undirected graph has a cycle, and split the vertices of an undirected graph into two teams so that no edge joins two vertices on the same team. Each problem takes a `Graph<V>` and has a JUnit suite.

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
        HashSet.java                  # a hash set with separate chaining, copied from the chaining chapter
      map/
        Map.java                      # unchanged copy of the course Map ADT
        HashMap.java                  # unchanged copy of the course hash table
      queue/
        Queue.java                    # unchanged copy of the course Queue ADT
        LinkedQueue.java              # unchanged copy of the course linked queue
      stack/
        Stack.java                    # unchanged copy of the course Stack ADT
        ArrayStack.java               # unchanged copy of the course array stack
      practice/
        Components.java               # connected components, with a depth-first search
        UndirectedCycle.java          # cycle in an undirected graph
        TwoTeams.java                 # two teams, with a breadth-first search
      demo/                           # one demo per solution class
        ComponentsDemo.java
        UndirectedCycleDemo.java
        TwoTeamsDemo.java
    test/
      practice/
        ComponentsTest.java
        UndirectedCycleTest.java
        TwoTeamsTest.java
  scripts/
    test.sh                           # compile and run the JUnit tests
    run.sh                            # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.TwoTeamsTest` — compiles everything and runs only that test class.
- `scripts/run.sh demo.TwoTeamsDemo` — compiles everything and runs that one demo. Every problem class has its own demo, `<Class>Demo`.

## What's here

- `practice.Components` — `countComponents`, a loop that runs a depth-first search from every vertex no earlier search reached.
- `practice.UndirectedCycle` — `hasCycle`, a depth-first search that skips the vertex it came from.
- `practice.TwoTeams` — `hasTwoTeams`, a breadth-first search that gives each vertex the other team from the vertex it was reached from.
- `practice.ComponentsTest`, `practice.UndirectedCycleTest`, and `practice.TwoTeamsTest` — one suite per problem.
- `demo.ComponentsDemo`, `demo.UndirectedCycleDemo`, and `demo.TwoTeamsDemo` — one demo per solution class, each on an example from the notes.
- `graph.Graph<V>` and `graph.AdjacencyListGraph<V>` — unchanged copies of the graph chapter's classes. Every problem takes a `Graph`.
- `set.Set<T>` and `set.HashSet<T>` — the same visited set as the chapter's code: the separate chaining chapter's hash set, copied unchanged. `hasCycle` keeps its visited vertices in one.
- `map.Map<K, V>` and `map.HashMap<K, V>` — unchanged copies of the course's map, which `AdjacencyListGraph` is built on. `hasTwoTeams` keeps each vertex's team in one.
- `queue.Queue<T>` and `queue.LinkedQueue<T>` — unchanged copies of the course's queue. `hasTwoTeams` keeps the vertices still to visit in one.
- `stack.Stack<T>` and `stack.ArrayStack<T>` — unchanged copies of the course's stack. `countComponents` keeps the vertices still to process in one.
