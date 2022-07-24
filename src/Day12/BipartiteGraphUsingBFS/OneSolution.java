package Day12.BipartiteGraphUsingBFS;

import java.util.*;
/*
Input:
Enter number of nodes:
10
Enter number of edges:
10
Enter all the edges:
1 2
2 3
3 4
4 5
5 6
6 7
7 8
8 3
6 9
9 10
Output: Graph is Bipartite

Input:
Enter number of nodes:
9
Enter number of edges:
9
Enter all the edges:
1 2
2 3
3 4
4 5
5 6
6 7
7 3
5 8
8 9
Output: Graph is not Bipartite

Input:
Enter number of nodes:
5
Enter number of edges:
4
Enter all the edges:
1 2
2 3
3 4
4 5
Output: Graph is Bipartite

Time complexity: O(N+E) : Just using BFS algorithms
N for traversing all the nodes
E for traversing all the edges overall

Space complexity : O(N+E) + O(N) + O(N)
O(N+E) for adjacency list
O(N) for Colors array
O(N) for queue data structure
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
        int [] colors = new int[nodes+1];
        Arrays.fill(colors, -1);
        boolean result = colorGraph(adjacencyList, colors, nodes);

        if(result==true){
            System.out.println("Graph is Bipartite");
            return;
        }
        System.out.println("Graph is not Bipartite");
    }

    private static boolean colorGraph(ArrayList<ArrayList<Integer>> adjacencyList, int [] colors, int nodes){
        for(int i=1;i<=nodes;i++){
            if(colors[i]==-1){
                if(!isBipartite(i, adjacencyList, colors)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartite(int node, ArrayList<ArrayList<Integer>> adjacencyList, int [] colors){
        Queue<Integer> queue = new LinkedList<Integer>();
        colors[node] = 0;
        queue.add(node);

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            for(Integer adjacentNode : adjacencyList.get(vertex)){
                if(colors[adjacentNode]==-1){
                    colors[adjacentNode] = 1 - colors[vertex];
                    queue.add(adjacentNode);
                }
                else if(colors[adjacentNode] == colors[vertex]){
                    return false;
                }
            }
        }

        return true;
    }
}
