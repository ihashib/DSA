package Graph;

import java.util.*;

public class Graph {
    //adjacency list
    private LinkedList<Integer> adjList[];      //created an array of linkedlist
    //number of vertices present in graph
    private int nodeCount = 0;

    //constructor, adding all the needed vertices
    public Graph(int nodeCount){
        this.nodeCount = nodeCount;
        adjList = new LinkedList[nodeCount];    //array of linkedlist size

        for(int i = 0; i < nodeCount; i++){
            //each node is a linked list
            //the whole graph is an array of nodes that are linkedlist
            //nodes are represented by linkedlist is because of the edges that need to connect
            adjList[i] = new LinkedList<>();
        }
    }

    //connecting each node with edges
    public void addEdge(int node1, int node2){
        //adding edges to a specific node, the node is an element of the array
        //the edge info is saved in the linkedlist of that node element
        adjList[node1].add(node2);
    }

    //bfs
    public void BFS(int startNode){
        boolean visited[] = new boolean[nodeCount];
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        visited[startNode] = true;

        while(q.size() != 0){
            //taking the first element in queue
            int currentNode = q.poll();

            //the main thing we are doing, printing the graph
            System.out.println("Current Node: "+currentNode);

            //taking a iterator that iterates though the current node's connected node via edges
            //if the connected node is not visited, enqueue it
            for (int nextNode : adjList[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }
}
