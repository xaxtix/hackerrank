package com.isamorodov.submission.graph_teory;

import java.util.*;

/**
 * Created by xaxtix on 05.03.2018.
 */
public class ShortestReach {

    static int[] lengthOfNodes;
    static boolean[] visited;

    static int[] bfs(int n, int m, int[][] edges, int s) {

        lengthOfNodes = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            lengthOfNodes[i] = -1;
        }
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < m; i++) {
            int[] e = edges[i];
            e[0]--;
            e[1]--;
            if (graph[e[0]] == null) graph[e[0]] = new ArrayList<>(n);
            if (graph[e[1]] == null) graph[e[1]] = new ArrayList<>(n);

            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        find(s - 1, graph);

        return lengthOfNodes;
    }

    private static void find(int s, List<Integer>[] graph) {
        if (graph[s] == null) return;
        visited[s] = true;

        Set<Integer> set = new HashSet<>();
        set.add(s);
        int len = 6;

        Set<Integer> notVisited = new HashSet<>();
        while (!set.isEmpty()) {
           notVisited.clear();

           for(int sl : set) {
               for (int node : graph[sl]) {
                   if (!visited[node]) {
                       visited[node] = true;
                       lengthOfNodes[node] = len;
                       notVisited.add(node);
                   }
               }
           }
           set.clear();
           set.addAll(notVisited);
           len += 6;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for (int edges_i = 0; edges_i < m; edges_i++) {
                for (int edges_j = 0; edges_j < 2; edges_j++) {
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                if (i == s - 1) continue;
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
