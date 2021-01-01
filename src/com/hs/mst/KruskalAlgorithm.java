package com.hs.mst;

import java.util.*;

public class KruskalAlgorithm{

    static int[] parent = new int[9];

    public static int findParent(int search){
        if(parent[search] == search) return search;

        return parent[search] = findParent(parent[search]);
    }

    public static void unionParent(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);

        parent[aParent] = bParent;
    }

    static class Edge implements Comparable<Edge>{
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight){
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args){
        for(int i = 1 ; i < 9; i++){
            parent[i] = i;
        }

        int edgeCount = 0;
        List<Edge> result = new ArrayList<>();

        //step1
        List<Edge> arr = new ArrayList<>();
        arr.add(new Edge(1,2,2));
        arr.add(new Edge(1,4,4));
        arr.add(new Edge(1,4,3));
        arr.add(new Edge(2,4,4));
        arr.add(new Edge(2,3,2));
        arr.add(new Edge(2,5,6));
        arr.add(new Edge(5,3,1));
        arr.add(new Edge(3,6,4));

        //step2
        Collections.sort(arr);

        //stap3
        for(Edge e : arr){
            if(findParent(e.node1) != findParent(e.node2)){
                unionParent(e.node1,e.node2);
                result.add(new Edge(e.node1,e.node2,e.weight));
                edgeCount++;
            }
            if(edgeCount == 5) break;
        }

        //result
        for(Edge e : result){
            System.out.println("node1 : " + e.node1 + " node2 : " + e.node2 + " weight : " + e.weight);
        }
    }
}
