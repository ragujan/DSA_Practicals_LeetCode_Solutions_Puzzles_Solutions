package com.rag.practicals.graphs;

public class Dijkstras<T> {

    static final int VERTEX_COUNT = 9;

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < VERTEX_COUNT; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printSolution(int dist[]) {

    }

    void algorithmInPlay(int graph[][], int src) {
        int dist[] = new int[VERTEX_COUNT];

        Boolean sptSet[] = new Boolean[VERTEX_COUNT];

        for (int i = 0; i < VERTEX_COUNT; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < sptSet.length - 1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            // iterate throught u's adjacency vertices
            for (int verticeOfU = 0; verticeOfU < VERTEX_COUNT; verticeOfU++) {

                // conditions are
                // sptSet[verticeOfU] has to be false
                // graph[u][v] shouldn't be 0
                // dist[u] shouldn't be MAX_VALUE
                // dist[u] + graph[u][v] should be lesser than dist[verticeOfU]
                if (!sptSet[verticeOfU]
                        && graph[u][verticeOfU] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][verticeOfU] < dist[verticeOfU]) {
                    dist[verticeOfU] = dist[u] + graph[u][verticeOfU];

                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print("i: " + i + " => " + dist[i] + "|| ");
        }

    }

    // Driver's code
    public static void main(String[] args) {
        /*
         * Let us create the example graph discussed above
         */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstras<Integer> t = new Dijkstras<Integer>();

        // Function call
        t.algorithmInPlay(graph, 2);
    }
}
