package org.example;

import Graph.Graph;

public class Main {
    public static void main(String[] args) {
        //create graph
        Graph graph = new Graph(6);
        //undirected
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);

        //BFS
        System.out.println("BFS: ");
        graph.BFS(0);

        //DFS
        System.out.println("DFS: ");
        graph.DFSWrapper(0);
    }
}