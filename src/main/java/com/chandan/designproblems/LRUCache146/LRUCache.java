package com.chandan.designproblems.LRUCache146;

import java.util.HashMap;

class ListNode {
    ListNode prev;
    ListNode next;
    int key;
    int val;
    public ListNode(int key, int val) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, ListNode> map = new HashMap<>();
    int size;
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);

    public LRUCache(int capacity) {
        this.size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode temp = map.get(key);
            deleteNode(temp);
            addNode(temp);
            return temp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteNode(map.get(key));
        }
        if(size == map.size()) {
            deleteNode(tail.prev);
        }
        addNode(new ListNode(key, value));
    }

    public void addNode(ListNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode(ListNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
