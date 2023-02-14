package com.anzj.sort;

import java.util.Arrays;

/**
 * @author anzj
 * @date 2022/6/22 9:39
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] a,int begin ,int end){
        if(begin>end)
            return;
        int key = a[begin];
        int i = begin;
        int j = end;
        int temp;
        while(i != j){
            while(a[j] >= key && i < j)
                j--;
            while(a[i] <= key && i < j)
                i++;
            if(i < j){
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        a[begin] = a[i];
        a[i] = key;
        sort(a,begin,i-1);
        sort(a,i+1,end);
    }

    public static void main(String[] args) {
        int arr[] = {4,2,5,3,1};
        sort(arr,0,2);
        System.out.println(Arrays.toString(arr));
    }
}
