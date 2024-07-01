package com.chandan.topic.design.DesignInMemoryFileSystem588;

import java.util.*;

public class FileSystemBetterSearch {
    TrieNode1 root = new TrieNode1();

    public List<String> ls(String path) {
        TrieNode1 currNode = root;
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
        List<String> children = new LinkedList<>(currNode.children.keySet()); //Already sorted as using TreeMap
        return children; // O(m) how many directories go down to
    }

    public void mkdir(String path) {
        getNode(path); //O(m)
    }

    public TrieNode1 getNode(String path) { // O(mlog(k))
        TrieNode1 currNode = root;
        String[] arr = path.split("/");
        for(int i = 1; i < arr.length; i++) {
            String currString = arr[i];
            if(!currNode.children.containsKey(currString)) {
                currNode.children.put(currString, new TrieNode1()); //log(k)
            }
            currNode = currNode.children.get(currString);
        }
        return currNode;
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode1 currNode = getNode(filePath);
        if(currNode.content == null) {
            currNode.content = content;
        } else {
            currNode.content += content;
        }
    }

    public String readContentFromFile(String filePath) {
        TrieNode1 currNode = getNode(filePath);
        return currNode.content;
    }
}
class TrieNode1 {
    String content;
    Map<String, TrieNode1> children;

    public TrieNode1() {
        content = null;
        children = new TreeMap<>();
    }
}
