package com.chandan.neetcode150.linkedlist.AddTwoNumbers2;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode ptr = l3;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int sum = l1val + l2val + carry;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            carry = sum / 10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0) {
            ptr.next = new ListNode(carry);
        }
        return l3.next;
    }
}
