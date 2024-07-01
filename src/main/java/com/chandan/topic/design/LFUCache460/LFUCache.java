package com.chandan.topic.design.LFUCache460;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int key;
        int value;
        int count;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        Node removeLast() {
            if(size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int capacity;
    int size;
    int minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DoublyLinkedList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) return -1;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            if(size == capacity) {
                DoublyLinkedList minFreqList = countMap.get(minFreq);
                Node removedNode = minFreqList.removeLast();
                nodeMap.remove(removedNode.key);
                size--;
            }
            size++;
            minFreq = 1;
            DoublyLinkedList newList = countMap.getOrDefault(node.count, new DoublyLinkedList());
            newList.add(node);
            countMap.put(node.count, newList);
        }
    }

    private void update(Node node) {
        DoublyLinkedList oldList = countMap.get(node.count);
        oldList.remove(node);
        if(oldList.size == 0 && node.count == minFreq)
            minFreq++;
        node.count++;
        DoublyLinkedList newList = countMap.getOrDefault(node.count, new DoublyLinkedList());
        newList.add(node);
        countMap.put(node.count, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
