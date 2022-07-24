package Day12.CycleDetectioninUndirectedGraphUsingBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
Input:
Enter number of nodes:
11
Enter number of edges:
10
Enter all the edges:
1 2
2 4
3 5
5 6
6 7
7 8
8 9
9 10
10 5
8 11
Output: Cycle Detected...

Input:
Enter number of nodes:
11
Enter number of edges:
9
Enter all the edges:
1 2
2 4
3 5
5 6
6 7
7 8
8 11
8 9
9 10
Output: Cycle not detected...

Time complexity: O(N+E)- Just applying BFS algorithm
N is time taken for visiting N nodes
E is for traversing through adjacent nodes overall

Space complexity: O(N+E) + O(N) + O(N)
O(N+E) - Adjacency list
O(N) - Visited array
O(N) - Queue data structure

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
        boolean result = cycleDetection(adjacencyList, visited, nodes);

        if(result==true){
            System.out.println("Cycle Detected...");
            return;
        }
        System.out.println("Cycle not detected...");
    }

    private static boolean cycleDetection(ArrayList<ArrayList<Integer>> adjacencyList, boolean [] visited, int nodes){
        for(int i=1;i<=nodes;i++){
            if(!visited[i]){
                if(cycleDetect(i, adjacencyList, visited, nodes)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleDetect(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean [] visited, int nodes){
        Queue<Pair> pair = new LinkedList<>();
        pair.add(new Pair(node, -1));
        visited[node] = true;

        while(!pair.isEmpty()){
            int vertex = pair.peek().node;
            int parent = pair.peek().parentNode;
            pair.poll();

            for(Integer adjacentNode:adjacencyList.get(vertex)){
                if(visited[adjacentNode] == false){
                    visited[adjacentNode] = true;
                    pair.add(new Pair(adjacentNode, vertex));
                }
                else if(adjacentNode != parent){
                        return true;
                }
            }
        }

        return false;
    }
}

class Pair{
    int node;
    int parentNode;
    Pair(int node, int parentNode){
        this.node = node;
        this.parentNode = parentNode;
    }
}
