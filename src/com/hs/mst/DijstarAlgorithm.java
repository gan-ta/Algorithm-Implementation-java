package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijstarAlgorithm {

    static final int INF = 10000000;

    static int[] result = new int[7];

    static class MapInfo{
        int node;
        int weight;

        public MapInfo(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

    }

    static class Search implements Comparable<Search>{
        int adjacentNode;
        int weight;

        public Search(int adjacentNode,int weight){
            this.adjacentNode = adjacentNode;
            this.weight  =weight;
        }

        @Override
        public int compareTo(Search search) {
            return this.weight - search.weight;
        }
    }

    static void dijstra(int start, List<List<MapInfo>> map){
        result[start] = 0;
        PriorityQueue<Search> pq = new PriorityQueue<>();
        pq.add(new Search(4,0));

        while(!pq.isEmpty()){
            int searchNode = pq.peek().adjacentNode;
            int accumulateDist = pq.peek().weight;
            pq.poll();
            for(int i = 0 ; i < map.get(searchNode).size(); i++){
                int adjacentNode  = map.get(searchNode).get(i).node;
                int adjacentDist = accumulateDist + map.get(searchNode).get(i).weight;

                if(adjacentDist < result[adjacentNode]){
                    result[adjacentNode] = adjacentDist;
                    pq.add(new Search(adjacentNode,adjacentDist));
                }

            }

        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 7; i++){
            result[i] = INF;
        }

        //노드 연결정보 저장
        List<List<MapInfo>> map = new ArrayList<>();
        List<MapInfo> insert = new ArrayList<>();
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(2,2));
        insert.add(new MapInfo(4,3));
        insert.add(new MapInfo(4,4));
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(1,2));
        insert.add(new MapInfo(4,4));
        insert.add(new MapInfo(3,2));
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(2,2));
        insert.add(new MapInfo(5,1));
        insert.add(new MapInfo(6,4));
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(1,4));
        insert.add(new MapInfo(1,3));
        insert.add(new MapInfo(2,4));
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(2,6));
        insert.add(new MapInfo(3,1));
        map.add(insert);
        insert = new ArrayList<>();

        insert.add(new MapInfo(3,4));
        map.add(insert);

        dijstra(4,map);

        for(int i =1; i < 7 ; i++){
            System.out.println(i + ": " + result[i]);
        }
    }

}
