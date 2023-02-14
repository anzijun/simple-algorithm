package com.anzj.sort;

import java.util.Arrays;
/**
 * @author anzj
 * @date 2022/6/22 15:15
 * 插入排序
 */
public class InsertionSort {

    public static void sort(int[] arr){
        int temp,j;
        for (int i = 1; i <arr.length; i++) {
            temp = arr[i];
            j = i-1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    public static void main(String[] args) {

        int[] array = {3,5,6,2,1,4};
        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间："+(end-start));
        System.out.println(Arrays.toString(array));
    }
}
