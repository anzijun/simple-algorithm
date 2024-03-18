package com.anzj.algorithm.leetcode;

/**
 * @Author anzj
 * @Date 2024/3/17
 *斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 */
public class LeetCode509 {
    public static void main(String[] args) {
        System.out.println(fibonacci(2));
        System.out.println(fib(2));
    }
    public static int fibonacci(int n){
        if(n == 0 || n == 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
}
