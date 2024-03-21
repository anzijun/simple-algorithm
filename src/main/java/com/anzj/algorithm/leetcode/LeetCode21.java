package com.anzj.algorithm.leetcode;

public class LeetCode21 {

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
}
class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode() {}
    LinkedNode(int val) { this.val = val; }
    LinkedNode(int val, LinkedNode next) { this.val = val; this.next = next; }
}