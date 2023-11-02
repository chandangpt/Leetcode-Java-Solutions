package com.chandan.designproblems.DesignInMemoryFileSystem588;

import java.util.*;

public class FileSystem {
    TrieNode root = new TrieNode();

    public List<String> ls(String path) {
        TrieNode currNode = root;
        if(!path.equals("/")) {
            // Find the directory
            String[] list = path.split("/");
            String currString;
            for(int i = 1; i < list.length; i++) {
                currString = list[i];
                currNode = currNode.children.get(currString);
                if(i == list.length - 1 && currNode.content != null) {
                    return Arrays.asList(currString);
                }
            }
        }
        List<String> children = new LinkedList<>(currNode.children.keySet());
        Collections.sort(children); // o(m+klog(k))(k elements as children)
        return children;
    }

    public void mkdir(String path) {
        getNode(path); //O(m)
    }

    public TrieNode getNode(String path) {
        TrieNode currNode = root;
        String[] arr = path.split("/");
        for(int i = 1; i < arr.length; i++) {
            String currString = arr[i];
            if(!currNode.children.containsKey(currString)) {
                currNode.children.put(currString, new TrieNode());
            }
            currNode = currNode.children.get(currString);
        }
        return currNode;
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode currNode = getNode(filePath);
        if(currNode.content == null) {
            currNode.content = content;
        } else {
            currNode.content += content;
        }
    }

    public String readContentFromFile(String filePath) {
        TrieNode currNode = getNode(filePath);
        return currNode.content;
    }
}
class TrieNode {
    String content;
    Map<String, TrieNode> children;

    public TrieNode() {
        content = null;
        children = new HashMap<>();
    }
}