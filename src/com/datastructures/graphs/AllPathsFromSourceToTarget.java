package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AllPathsFromSourceToTarget {

    class GraphNode{
        int value;
        List<GraphNode> connectedVertices;

        public GraphNode(int val){
            this.value = val;
            connectedVertices = new ArrayList<>();
        }

        public void addVertex(GraphNode node){
            this.connectedVertices.add(node);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        HashMap<Integer,GraphNode> mapOfNodes = new HashMap<>();
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i<graph.length; i++){
            GraphNode crt = null;
            if(mapOfNodes.get(i) != null) {
                crt = mapOfNodes.get(i);
            }else{
                crt = new GraphNode(i);
            }
            for(int j = 0; j<graph[i].length; j++){
                GraphNode vertex = null;
                int val = graph[i][j];
                if(mapOfNodes.get(val) == null) {
                    vertex = new GraphNode(val);
                }else{
                    vertex = mapOfNodes.get(val);
                }
                crt.addVertex(vertex);
                mapOfNodes.put(val,vertex);
            }
            mapOfNodes.put(i, crt);
        }

        for(int i : mapOfNodes.keySet()){
            for(int j = 0; j < mapOfNodes.get(i).connectedVertices.size(); j++){
                System.out.println(i+ "->" + mapOfNodes.get(i).connectedVertices.get(j).value);
            }
        }

        GraphNode starting = mapOfNodes.get(0);

        helper(starting, output, new ArrayList<Integer>(), graph.length-1);
        return output;
    }

    public void helper(GraphNode temp,List<List<Integer>> output, List<Integer> res, int answer){
        if(temp == null) return;
        if(temp.value == answer) {
            res.add(temp.value);
            output.add(new ArrayList(res));
            return;
        }
        res.add(temp.value);
        for(int i =0;i < temp.connectedVertices.size(); i++){
            GraphNode v = temp.connectedVertices.get(i);
            helper(v, output, res, answer);
            res.remove(res.size()-1);
        }

    }

    public static void main(String[] args) {
        new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }

}
