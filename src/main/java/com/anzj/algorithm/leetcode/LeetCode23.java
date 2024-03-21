package com.anzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode23 {

    /**
     * 递归分治法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return partRecursion(lists,0,lists.length-1);
    }
    private ListNode partRecursion(ListNode lists[],int s,int e){
        if(s == e){
            return lists[0];
        }
        int mid = s + (e-s)/2;
        ListNode l1 = partRecursion(lists,s,mid);
        ListNode l2 = partRecursion(lists,mid+1,e);
        return merge2List(l1,l2);
    }
    private ListNode merge2List(ListNode l1,ListNode l2){
        ListNode base = new ListNode(0);
        ListNode offSet = base;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                offSet.next = l1;
                l1 = l1.next;
            }else{
                offSet.next = l2;
                l2 = l2.next;
            }
            offSet = offSet.next;
        }
            offSet.next = l1 == null ? l2 : l1;
            return base.next;
    }
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
                current = current.next;
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