package com.datastructures.disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Long,Node> findMap = new HashMap<>();
    class Node{
        long data;
        int rank;
        Node parent;
    }

    public void makeset(long data){
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        findMap.put(data,node);
    }
    public void union(long data1, long data2){
        Node node1 = findMap.get(data1);
        Node node2 = findMap.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1.data == parent2.data) return;
        if(parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank+1 : parent1.rank;

            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
    }
    public int findset(int data){
        return findMap.get(data).rank;
    }

    public Node findSet(Node node){
        if(node.parent == node){
            return node.parent;
        }
        return node.parent = findSet(node.parent);
    }
}
