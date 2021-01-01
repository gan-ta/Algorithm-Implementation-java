package com.hs.mst;

import java.util.ArrayList;
import java.util.List;


public class UnionFind {

    static class Edge{
        int node1;
        int node2;

        public Edge(int node1, int node2){
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    static int[] parent = new int[6];

    public static int findParent(int search){
        if(parent[search] == search) return search;

        return parent[search] = findParent(parent[search]);
    }

    public static void unionParent(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);

        parent[aParent] = bParent;
    }

    public static void main(String[] args) {
        //간선의 정보를 저장
        List<Edge> map =new ArrayList<>();
        map.add(new Edge(1,2));
        map.add(new Edge(1,3));
        map.add(new Edge(4,5));

        for(int i = 1 ; i < 6; i++){
            parent[i] = i;
        }

        for(Edge e: map){
            unionParent(e.node1, e.node2);
        }

        for(int i = 1; i < 6; i++){
            System.out.println(i +  ": " + parent[i]);
        }
    }
}
