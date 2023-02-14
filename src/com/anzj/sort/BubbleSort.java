package com.anzj.sort;

import java.util.Arrays;

/**
 * @author anzj
 * @date 2022/6/22 8:19
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] array){

        int a;
        int count = 0;
        boolean isSwap = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]){
                    a = array[j+1];
                    array[j+1] = array[j];
                    array[j] = a;
                    isSwap = true;
                }
            }
            count++;
            if (!isSwap)
                break;
            isSwap = false;
        }
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("共排序了"+count+"次就完成了");
    }
    public static void main(String[] args) {
        int arr[]={6,5,4,3,2,1};
        long start = System.currentTimeMillis();
        System.out.println(start);
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("消耗时间："+(end-start));
        System.out.println(Arrays.toString(arr));
    }
}
