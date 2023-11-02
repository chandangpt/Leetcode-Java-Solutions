package com.chandan.advancedatastructures.ImplementTrie208;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    final Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord  = false;
    }
}
class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            if(!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode());
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            if(!curr.children.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.children.get(word.charAt(i));
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(!curr.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.children.get(prefix.charAt(i));
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
