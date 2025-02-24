package com.chandan.neetcode150.graphs.CloneGraph133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            Node neighborNode = cloneGraph(neighbor);
            newNode.neighbors.add(neighborNode);
        }
        return newNode;
    }
}
