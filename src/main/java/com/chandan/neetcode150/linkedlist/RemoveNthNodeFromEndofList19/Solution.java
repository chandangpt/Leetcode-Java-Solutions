package com.chandan.neetcode150.linkedlist.RemoveNthNodeFromEndofList19;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head, ptr1 = head, prev = null;
        while(n-- != 0) {
            ptr = ptr.next;
        }
        while(ptr != null) {
            ptr = ptr.next;
            prev = ptr1;
            ptr1 = ptr1.next;
        }
        if(prev == null)
            return head.next;
        prev.next = prev.next.next;
        return head;
    }
}
