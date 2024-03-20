package com.anzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode23 {

    /**
     * 简单清晰解法
     * 遍历所有节点,将节点值加入到数组中,数组进行排序,然后将数组转换成listNode链表
     *
     */
    public ListNode mergeList(ListNode[] nodes){
        if(nodes.length == 0)
            return null;
        List<Integer> source = new ArrayList<>();
        for (ListNode node : nodes) {
            ListNode current = node;
            source.add(current.val);
            while (current.next != null){
                current = node.next;
                source.add(current.val);
            }
        }
        int arr[] =  new int[source.size()];
        int count = 0;
        for(Integer i : source){
            arr[count++] = i;
        }
        Arrays.sort(arr);
        ListNode head = new ListNode(arr[0]);
        ListNode iterator;
        iterator = head;
        for (int i =1 ; i < arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);
            iterator.next = newNode;
            iterator = newNode;
        }
        return head;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(){}
    public ListNode(int val){this.val = val;}
    public ListNode(int val,ListNode node){
        this.val = val;
        this.next = node;
    }
}