package org.example;

import java.util.List;

import Graph.Graph;

public class Main {
    public static void main(String[] args) {
        //create graph
        Graph graph = new Graph();
        //directed
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 8);
        graph.addEdge(5, -1);
        graph.addEdge(6, 7);
        graph.addEdge(6, 11);
        graph.addEdge(7, 4);
        graph.addEdge(7, 12);
        graph.addEdge(8, -1);
        graph.addEdge(9, 2);
        graph.addEdge(9, 10);
        graph.addEdge(10, 6);
        graph.addEdge(11, 12);
        graph.addEdge(12, 8);

        graph.printGraph();

        // //BFS
        // System.out.println("BFS: ");
        // graph.BFS(0);

        // //DFS
        // System.out.println("DFS: ");
        // graph.DFSWrapper(0);
        List<Integer> order = graph.topSort();
        System.out.println(order);

    }
}