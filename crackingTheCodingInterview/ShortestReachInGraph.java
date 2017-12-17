package crackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReachInGraph {
	public static class Graph {
        
        int size;
        List<Integer>[] edges;
        
        public Graph(int size) {
            this.size = size;
            this.edges = new List[size];
            for(int i=0; i<size; i++)
            	edges[i] = new ArrayList<>();
        }

        public void addEdge(int first, int second) {
        	edges[first].add(second);
        	edges[second].add(first);
        }
        
        public int[] shortestReach(int startId) {
        	int[] distances = new int[size];
            Queue<Integer> queue = new LinkedList<>();
            Arrays.fill(distances, -1);
            distances[startId] = 0;
            queue.add(startId);
            
            while (!queue.isEmpty()){
            	int current = queue.poll();
        		for (int edge : edges[current]){
        		
        			if (distances[edge] == -1){
                		distances[edge] = 6 + distances[current];
                		queue.offer(edge);
        			}
        			
        		}
                
            }
            
            return distances;
        }
        
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
