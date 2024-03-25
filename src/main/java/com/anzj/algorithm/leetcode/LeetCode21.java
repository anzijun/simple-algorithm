package com.anzj.algorithm.leetcode;

public class LeetCode21 {

    /**
     * 普通遍历解法
     */
    public LinkedNode mergeList(LinkedNode l1,LinkedNode l2){
        LinkedNode target = new LinkedNode(0);
        LinkedNode point = target;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                point.next = l1;
                l1 = l1.next;
            }else {
               point.next = l1;
               l2 = l2.next;
            }
            point = point.next;
        }
        point.next = l1 == null ? l2 : l1;
        return target.next;
    }

    /**
     * 递归解法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode() {}
    LinkedNode(int val) { this.val = val; }
    LinkedNode(int val, LinkedNode next) { this.val = val; this.next = next; }
}