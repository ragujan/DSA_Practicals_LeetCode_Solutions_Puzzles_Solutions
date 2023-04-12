package com.rag.leet_code.minimum_score_path_two_cities.atempt_2;

import com.rag.leet_code.minimum_score_path_two_cities.practice_dfs.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    class Graph{
        Map<Integer, Set>[] vertices ;
        int nodeCount ;
        Graph(int nodeCount){
            this.nodeCount = nodeCount;
            vertices = new Map[nodeCount];
            for (int i = 0; i <nodeCount ; i++) {
               vertices[i] = new HashMap<>();
            }

        }
        public void addEdges(int node,int connectingNode){

        }
    }
}
