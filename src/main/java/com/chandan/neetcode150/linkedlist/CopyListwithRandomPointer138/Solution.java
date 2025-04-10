package com.chandan.neetcode150.linkedlist.CopyListwithRandomPointer138;


import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> oldNodeMap = new HashMap<>();
        HashMap<Integer, Node> newNodeMap = new HashMap<>();
        Node head1 = new Node(-1);
        Node ptr1 = head1;
        Node ptr = head;
        int index = 0;
        while(ptr != null) {
            Node newNode = new Node(ptr.val);
            oldNodeMap.put(ptr, index);
            newNodeMap.put(index, newNode);
            index++;
            ptr1.next = newNode;
            ptr1 = ptr1.next;
            ptr = ptr.next;
        }
        ptr1 = head1.next;
        ptr = head;
        while(ptr1 != null) {
            if(ptr.random == null) {
                ptr1.random = null;
            } else {
                ptr1.random = newNodeMap.get(oldNodeMap.get(ptr.random));
            }
            ptr = ptr.next;
            ptr1 = ptr1.next;
        }
        return head1.next;
    }
}
