package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    //adjacency list
    private List<List<Integer>> adjList;      //created a list within a list of integer type
    //number of vertices present in graph
    private int nodeCount = 0;

    public Graph(){
        adjList = new ArrayList<>();
    }

    public void addEdge(int sendingNode, int receiverNode) {
        ensureNodeExists(sendingNode); 

        if (receiverNode != -1 && !adjList.get(sendingNode).contains(receiverNode)) {
            adjList.get(sendingNode).add(receiverNode);
        } 
    }

    // Helper method to add a new node if it doesn't exist
    private void ensureNodeExists(int nodeIndex) {
        if (!isIndexValid(adjList, nodeIndex)) { 
            adjList.add(nodeIndex, new ArrayList<>()); // Initialize with an empty list
            nodeCount++;
        }
    }


    public boolean isIndexValid(List list, int index) {
        return index >= 0 && index < list.size();
    }

    public void printGraph(){
        int count = 0;
        for(List<Integer> l : adjList){
            System.out.println(count+" :"+l);
            count++;
        }
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
            List<Integer> connectedVerticies = adjList.get(currentNode);
            //if the connected node is not visited, enqueue it
            for (int nextNode : connectedVerticies) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }

    //dfs
    public void DFSWrapper(int startNode){
        boolean visited[] = new boolean[nodeCount];

        DFS(startNode, visited);
    }
    private void DFS(int node, boolean visited[]){
        if(node == -1) return;

        visited[node] = true;

        System.out.println("Current Node: "+ node);

        List<Integer> connectedVertecies = adjList.get(node);

        for(int nextNode : connectedVertecies){
            if(!visited[nextNode]){
                visited[nextNode] = true;

                DFS(nextNode, visited);
            }
        }
    }

    //Topological sort
    public List<Integer> topSort(){
        /*
         * We traverse the graph using DFS at a random node till we find the end of the subtree
         * The end of the subtree means, that node does not have any dependent nodes
         * From the DFS algo, we use the visited list and reverse it, because we want the node with no dependency first
         * Example= Graph: 1 -> 2 -> 3, visited[] = [1,2,3] -> reverse visited[] = [3,2,1] 
         * Add the reversed visited to the order list 
         * Return order list when all nodes are traversed
         */
        List<Integer> order = new ArrayList<>();

        for(int vertex = 0; vertex < nodeCount; vertex++){
            if(!order.contains(vertex)){
                List<Integer> visited = new ArrayList<>();
                dfsForTopSort(visited, vertex, order);

                Collections.reverse(visited);
                for(int i : visited)
                    order.add(i);
            }
        }
        Collections.reverse(order);

        return order;
    }
    //DFS wrapper for topological sort, to find the end of a subtree
    public void dfsForTopSort(List<Integer> visited, int vertex, List<Integer> order){
        Stack<Integer> stack = new Stack<>();

        stack.push(vertex);
        visited.add(vertex);

        while(!stack.isEmpty()){
            int popedVertex = stack.pop();
            List<Integer> connectedVertecies = adjList.get(popedVertex);

            for(int connected : connectedVertecies){
                if(!visited.contains(connected) && !order.contains(connected)){
                    stack.push(connected);
                    visited.add(connected);
                }
            }
        }
    }
}
