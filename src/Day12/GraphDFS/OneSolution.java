package Day12.GraphDFS;

import java.util.ArrayList;
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
2 4
4 6
6 7
7 2
3 5
Output:
DFS Traversal Path: [1, 2, 4, 6, 7, 3, 5]

Time complexity: O(N+E)
N is the time taken for visiting N nodes, and E is for travelling through adjacent nodes overall

Space complexity: O(N+E) + O(N) + O(N)
O(N+E) - For adjacency list
O(N) - For visited array
O(N) - Recursion stack space
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
        ArrayList<Integer> dfs = new ArrayList<>();

        for(int node=1;node<=nodes;node++){
            if(!visited[node]){
                dfsTraversal(node, adjacencyList, visited, dfs);
            }
        }

        System.out.println("DFS Traversal Path: "+dfs);
    }

    private static void dfsTraversal(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean [] visited, ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for(Integer adjacentNode: adjacencyList.get(node)){
            if(!visited[adjacentNode]){
                dfsTraversal(adjacentNode, adjacencyList, visited, dfs);
            }
        }
    }
}
