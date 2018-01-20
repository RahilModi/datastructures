package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.HashSet;

public class TopologicalSort <T>{

    Deque<Vertex<T>> sorted =  new ArrayDeque<>();
    Set<Vertex<T>> visited = new HashSet<>();

    public Deque<Vertex<T>> topologicalSort (Graph<T> graph){
        for(Vertex<T> v: graph.getAllVertex()){
            if(visited.contains(v))continue;
            topSortUtil(v);
        }
        return sorted;
    }

    public void topSortUtil(Vertex<T> v){
        visited.add(v);
        for(Vertex<T> adjV : v.getAdjacentVertex()){
            if(visited.contains(adjV)) continue;
            topSortUtil(adjV);
        }
        sorted.offerFirst(v);
    }

    public static void main(String[] args) {
        TopologicalSort<Integer> t = new TopologicalSort<>();
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        Deque<Vertex<Integer>> opt = t.topologicalSort(graph);
        while(!opt.isEmpty()){
            System.out.println(opt.poll());
        }
    }


}
