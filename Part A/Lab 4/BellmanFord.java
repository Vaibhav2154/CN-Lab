// Write a program to find the shortest path between vertices using bellman-ford algorithm.


// bellman-ford algorithm.

//bellman ford algorithm for shortest distance from a source node to all the remaining nodes

import java.util.*;

public class BellmanFord {

    static final int INF = 999999;
    static int N;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Vertices: ");
        N = sc.nextInt();

        graph = new int[N][N];
        System.out.println("Enter the Weight Matrix of Graph (use " + INF + " for no edge):");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the Source Vertex: ");
        int source = sc.nextInt();

        bellmanFord(source - 1);
    }

    static void bellmanFord(int src) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Step 1: Relax edges V-1 times
        for (int i = 0; i < N - 1; i++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (graph[u][v] != INF &&
                        dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Step 2: Check for negative weight cycle
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                if (graph[u][v] != INF &&
                    dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Negative weight cycle detected.");
                    return;
                }
            }
        }

        // Step 3: Print result
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < N; i++) {
            if (dist[i] == INF)
                System.out.println((i + 1) + "\tINF");
            else
                System.out.println((i + 1) + "\t" + dist[i]);
        }
    }
}


/*output:-
Enter the number of Vertices : 5
Enter the Weight Matrix of Graph
0 6 0 7 0
0 0 5 8 -4
0 0 0 0 0
0 0 -3 0 9
2 0 0 0 0
Enter the Source Vertex : 1
Vertex   Distance from Source
1               0
2               6
3               4
4               7
5               2
*/


/*Enter the number of Vertices : 3
Enter the Weight Matrix of Graph
0 10 5
0 0 -8
0 0 0
Enter the Source Vertex : 1
Vertex   Distance from Source
1               0
2               10
3               2
*/


/*
Enter the number of Vertices : 3
Enter the Weight Matrix of Graph
0 10 0
0 0 20
0 -30 0
Enter the Source Vertex : 1
Negative weight cycle detected.
*/