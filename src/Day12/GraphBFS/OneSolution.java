package Day12.GraphBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
One of the most important Graph Algorithm
Input:
Enter number of nodes:
7
Enter number of edges:
6
Enter all the edges:
1 2
2 3
3 5
5 7
7 2
4 6

Output:
BFS Traversal Path: [1, 2, 3, 7, 5, 4, 6]

Time complexity: O(N+E)
N is the time taken for visiting N nodes, and E is for travelling through adjacent nodes overall

Space complexity: O(N+E) + O(N) + O(N)
O(N+E) - For adjacency list
O(N) - For visited array
O(N) - For Queue data structure
 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int nodes = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        // Considered 1 based indexing graph
        for(int i=0;i<=nodes;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }
        System.out.println("Enter all the edges: ");
        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        boolean [] visited = new boolean[nodes+1];
        ArrayList<Integer> bfs = new ArrayList<>();

        for(int node=1;node<=nodes;node++){
            if(!visited[node]){
                bfsTraversal(node, adjacencyList, visited, bfs);
            }
        }

        System.out.println("BFS Traversal Path: "+bfs);
    }

    private static void bfsTraversal(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean [] visited, ArrayList<Integer> bfs){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            bfs.add(vertex);

            for(Integer adjacentNode : adjacencyList.get(vertex)){
                if(!visited[adjacentNode]){
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }
    }
}
