# 🧩 ImportantAlgo — Essential Algorithms & Data Structures in Java

A comprehensive reference collection of **must-know algorithms and data structures** implemented in Java — covering Graph Theory, Dynamic Programming, Trees, Binary Search, Bit Manipulation, and Math. Built as a personal handbook for coding interviews and competitive programming.

---

## 📂 Complete File Index

| File | Algorithm / Data Structure | Category |
|---|---|---|
| `BFS.java` | Breadth-First Search | Graph |
| `DFS.java` | Depth-First Search | Graph |
| `IterativeDFSfor2D.java` | Iterative DFS on 2D Grid | Graph |
| `TopoSort.java` | Topological Sort (DFS-based) | Graph |
| `KahnsAlgorithm.java` | Kahn's Algorithm (BFS Topo Sort) | Graph |
| `CycleinUndirectedGraph.java` | Cycle Detection in Undirected Graph | Graph |
| `ShortestPathinDAG.java` | Shortest Path in DAG (Topo + Relaxation) | Graph |
| `ShortestPathinMaze.java` | Shortest Path in Binary Matrix (BFS) | Graph |
| `DijkstrasAlgo.java` | Dijkstra's Algorithm | Graph |
| `PrintShortestPathDisktras.java` | Dijkstra's with Path Reconstruction | Graph |
| `BellmanFormAlgo.java` | Bellman-Ford Algorithm | Graph |
| `PrimsAlgoMST.java` | Prim's Algorithm (MST) | Graph |
| `Kruskal'sAlgo.java` | Kruskal's Algorithm (MST) | Graph |
| `DisjointSet.java` | Disjoint Set Union (by Rank & by Size) | Graph / DSU |
| `AccountMerge.java` | Account Merge (DSU Application) | Graph / DSU |
| `KosarajuSCC.java` | Kosaraju's Algorithm (Strongly Connected Components) | Graph |
| `ArticulationPoint.java` | Articulation Points (Tarjan's) | Graph |
| `BridgeinGraphUsingTarjan'sAlgo.java` | Bridge Finding (Tarjan's Algorithm) | Graph |
| `FloodFill.java` | Flood Fill (DFS on 2D Grid) | Graph |
| `RottenOranges.java` | Rotten Oranges (Multi-source BFS) | Graph |
| `MergeIntervals.java` | Merge Intervals | Arrays |
| `BinarySearch.java` | Standard Binary Search | Binary Search |
| `LowerBound.java` | Lower Bound (first index ≥ target) | Binary Search |
| `UpperBound.java` | Upper Bound (first index > target) | Binary Search |
| `SearchinRotatedSortedArray.java` | Search in Rotated Sorted Array | Binary Search |
| `FindPeakElement.java` | Find Peak Element | Binary Search |
| `SegmentTree.java` | Segment Tree (Sum, Min, Lazy Propagation, Parenthesis) | Trees |
| `SegmentTreeMinQuery.java` | Segment Tree (Min Query) | Trees |
| `LCS.java` | Longest Common Subsequence (DP) | Dynamic Programming |
| `LIS.java` | Longest Increasing Subsequence (DP + Binary Search O(n log n)) | Dynamic Programming |
| `LISPrint.java` | LIS with Path Reconstruction | Dynamic Programming |
| `01KnapSack.java` | 0/1 Knapsack Problem (DP) | Dynamic Programming |
| `SubsetSum.java` | Subset Sum Problem (DP) | Dynamic Programming |
| `GetDiffStoneGameAliceBob.java` | Stone Game (Memoized DP) | Dynamic Programming |
| `GCDAlgo.java` | GCD — Euclidean Algorithm | Math |
| `SieveofEratosthenes.java` | Sieve of Eratosthenes (Prime Generation) | Math |
| `BinaryExponention.java` | Binary Exponentiation (Fast Power mod m) | Math |
| `ANDofNumberRange.java` | Bitwise AND of Number Range | Bit Manipulation |
| `Leetcode3315.java` | Min Bitwise Array (Bitwise Construction) | Bit Manipulation |

---

## 🗂️ Algorithms by Category

### 🔵 Graph Algorithms

#### Traversals
- **`BFS.java`** — Standard BFS using a queue; tracks visited nodes; returns traversal order. `O(V+E)`
- **`DFS.java`** — Recursive DFS; visits all connected nodes depth-first. `O(V+E)`
- **`IterativeDFSfor2D.java`** — Stack-based iterative DFS for 2D grids using directional arrays `{-1,0,1,0}` / `{0,1,0,-1}`

#### Cycle & Connectivity
- **`CycleinUndirectedGraph.java`** — BFS/DFS with parent tracking; cycle exists if a visited non-parent neighbor is found
- **`KosarajuSCC.java`** — Finds Strongly Connected Components in 3 steps: DFS to fill stack → transpose graph → DFS in stack order. `O(V+E)`
- **`ArticulationPoint.java`** — Tarjan's algorithm using `tin[]` (discovery time) and `tlow[]` (low-link values) to identify cut vertices
- **`BridgeinGraphUsingTarjan'sAlgo.java`** — Finds bridges (critical connections): edge `(u,v)` is a bridge if `tin[u] < tlow[v]`

#### Shortest Path
- **`DijkstrasAlgo.java`** — Min-heap `PriorityQueue` based; relaxes edges greedily. Works for non-negative weights. `O((V+E) log V)`
- **`PrintShortestPathDisktras.java`** — Dijkstra's extended with a `parent[]` array to reconstruct and print the actual shortest path
- **`BellmanFormAlgo.java`** — Relaxes all edges `V-1` times; detects negative weight cycles on the `V`th pass. `O(V·E)`
- **`ShortestPathinDAG.java`** — Topological sort + single-pass edge relaxation. Works on directed acyclic graphs only. `O(V+E)`
- **`ShortestPathinMaze.java`** — BFS on a binary matrix; finds the shortest 8-directional path from top-left to bottom-right. `O(n²)`

#### Minimum Spanning Tree
- **`PrimsAlgoMST.java`** — Greedy MST using a min-heap; always picks the cheapest edge crossing the cut. `O(E log V)`
- **`Kruskal'sAlgo.java`** — Sorts all edges by weight; adds edge if it connects two different components (using DSU). `O(E log E)`

#### Disjoint Set Union (DSU / Union-Find)
- **`DisjointSet.java`** — Two implementations:
  - **Union by Rank** — Attach smaller-rank tree under larger-rank root
  - **Union by Size** — Attach smaller-size component under larger; both with **path compression** in `findParent()`
- **`AccountMerge.java`** — Real-world DSU application: merges accounts sharing common emails using union-find

#### Grid Problems
- **`FloodFill.java`** — DFS-based color fill on a 2D image grid using 4-directional movement
- **`RottenOranges.java`** — Multi-source BFS: all initially rotten oranges enqueued at time 0; spread rot level by level

---

### 🟢 Dynamic Programming

| Algorithm | Approach | Time | Space |
|---|---|---|---|
| **LCS** | Bottom-up DP table `dp[m+1][n+1]` | O(m·n) | O(m·n) |
| **LIS** | Binary search on patience-sort list (O(n log n)) + DP tabulation fallback | O(n log n) | O(n) |
| **LIS Print** | DP with parent tracking for path reconstruction | O(n²) | O(n) |
| **0/1 Knapsack** | 2D DP table `dp[n][W+1]`; either include or exclude item | O(n·W) | O(n·W) |
| **Subset Sum** | Boolean DP table `dp[N+1][sum+1]` | O(N·sum) | O(N·sum) |
| **Stone Game (Alice & Bob)** | Memoized DFS; at each turn pick 1–3 piles, maximize score difference | O(n) | O(n) |

---

### 🔴 Graph Ordering

- **`TopoSort.java`** — DFS-based topological sort using a `Stack`; post-order push gives reverse topological order
- **`KahnsAlgorithm.java`** — BFS-based topo sort using in-degree array; processes zero-indegree nodes first. Also detects cycles in directed graphs

---

### 🟡 Binary Search

| File | Description |
|---|---|
| `BinarySearch.java` | Standard binary search on sorted array |
| `LowerBound.java` | Finds first index where `arr[idx] >= target` |
| `UpperBound.java` | Finds first index where `arr[idx] > target` |
| `SearchinRotatedSortedArray.java` | Identifies sorted half at each step, then checks if target lies in it |
| `FindPeakElement.java` | Binary search: move toward the uphill neighbor to guarantee finding a peak |

---

### 🌳 Segment Tree

**`SegmentTree.java`** — A full-featured segment tree implementation with:

| Operation | Description |
|---|---|
| `BuildSum` / `QuerySum` / `updateSum` | Range sum queries and point updates |
| `buildMin` / `QueryMin` / `updateMin` | Range minimum queries and point updates |
| `updateslazy` / `QueryLazy` | Lazy propagation for range updates in O(log n) |
| `BuildPar` / `QueryPar` / `updatePar` | Parenthesis validity queries using a custom `Pair(open, close, full)` struct and a `Merge()` function |

**`SegmentTreeMinQuery.java`** — Standalone min-query segment tree.

---

### 🔢 Math Algorithms

- **`GCDAlgo.java`** — Euclidean GCD: `gcd(a, b) = gcd(b % a, a)` until `a == 0`. `O(log(max(a,b)))`
- **`SieveofEratosthenes.java`** — Marks composite numbers iteratively up to `n`; efficiently finds all primes. `O(n log log n)`
- **`BinaryExponention.java`** — Fast modular exponentiation: square the base and halve the exponent each step. Computes `aᵇ mod m` in `O(log b)`

---

### 🔵 Bit Manipulation

- **`ANDofNumberRange.java`** — Bitwise AND of all numbers in `[left, right]`: repeatedly clear the lowest set bit of `right` until `right <= left`. The result is the common prefix of `left` and `right` in binary
- **`Leetcode3315.java`** — Constructs min bitwise array: for each number, finds the largest `x < num` such that `x | (x+1) == num`

---

### 📐 Arrays / Intervals

- **`MergeIntervals.java`** — Sort intervals by start time; greedily merge overlapping intervals. `O(n log n)`

---

## 🛠️ Language & Tools

- **Language:** Java
- **Data Structures Used:** `PriorityQueue`, `Stack`, `Queue`, `ArrayList`, `TreeSet`, `HashMap`
- **Paradigms:** Recursion, Memoization, Tabulation, Greedy, Divide & Conquer

---

## 🚀 How to Run

```bash
# Compile
javac BFS.java

# Run
java Solution
```

> Most files contain a standalone class. For local testing, wrap the logic in a `Main` class with a `main()` method and construct sample inputs.

---

## 📊 Complexity Quick Reference

| Algorithm | Time | Space |
|---|---|---|
| BFS / DFS | O(V+E) | O(V) |
| Dijkstra | O((V+E) log V) | O(V) |
| Bellman-Ford | O(V·E) | O(V) |
| Prim's / Kruskal's | O(E log E) | O(V) |
| Kosaraju SCC | O(V+E) | O(V) |
| Tarjan (Bridge/AP) | O(V+E) | O(V) |
| DSU (find/union) | O(α(n)) ≈ O(1) | O(n) |
| LCS | O(m·n) | O(m·n) |
| LIS (optimized) | O(n log n) | O(n) |
| 0/1 Knapsack | O(n·W) | O(n·W) |
| Segment Tree (query/update) | O(log n) | O(n) |
| Segment Tree (lazy range update) | O(log n) | O(n) |
| Sieve of Eratosthenes | O(n log log n) | O(n) |
| Binary Exponentiation | O(log b) | O(1) |
| GCD (Euclidean) | O(log(max(a,b))) | O(1) |
