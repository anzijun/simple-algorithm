package com.anzj.algorithm.leetcode;

/**
 *  @Author anzj
 *  @Date 2024/3/17
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 题解：
 * 1个台阶 ：1 种
 * 2个台阶 ： 1，1 和 2 共2种
 * 3个台阶 ：1，1，1 和 1，2 和 2，1 共3种
 * 四个台阶 ： 1，1，1，1 和 1，2，1 和 2，1，1 和 1，1，2 和 2，2 共5种
 * 由上可得 n == 1 时 f(n) = 1
 *        n == 2 时 f(n) = 2
 *        n == 3 时 f(n) = 3 = 1+2
 *        n == 4 时 f(n) = 5 = 3+2
 * 综上 n<=2时 f(n) = n;
 *     n>2 时 f(n) = (n-1) + (n-2)
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(climbStair(5));
    }
    public static int climbStair(int n){
        if(n == 1 || n == 2)
            return n;
        return climbStair(n-1) + climbStair(n-2);
    }
}
