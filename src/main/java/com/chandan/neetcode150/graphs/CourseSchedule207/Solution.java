package com.chandan.neetcode150.graphs.CourseSchedule207;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++)
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0)
                if(isCyclic(graph, visited, i))
                    return false;
        }
        return true;
    }

    boolean isCyclic(List<List<Integer>> graph, int[] visited, int current) {
        if(visited[current] == 2)
            return true;
        visited[current] = 2;
        for(int i = 0; i < graph.get(current).size(); i++) {
            if(visited[graph.get(current).get(i)] != 1) {
                if(isCyclic(graph, visited, graph.get(current).get(i)))
                    return true;
            }
        }
        visited[current] = 1;
        return false;
    }
}
