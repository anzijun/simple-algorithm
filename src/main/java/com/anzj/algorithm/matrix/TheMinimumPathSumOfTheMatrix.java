package com.anzj.algorithm.matrix;

/**
 * @author Orkesh
 * @time 2023/3/26 0:47
 *
 * P185 补充问题2 : 矩阵的最小路径和
 * 题目 : 给定一个矩阵 m , 从左上角开始每次只能向右或者向下走 ,
 * 最后到达右下角的位置 , 路径上所有数字累加起来就是路径和 ,
 * 返回所有的路径中最小的路径和  .
 *
 * 举例  :
 * 如果给定的 m 如下 :
 * 1   3   5   9
 * 8   1   3   4
 * 5   0   6   1
 * 8   8   4   0
 * 路径 1, 3, 1, 0, 6, 1, 0 是所有路径中路径和最小的 , 所以返回12 .
 */
public class TheMinimumPathSumOfTheMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        } ;
        int i = helper1(matrix, 3, 3);
        System.out.println();
        int[][] cache = new int[matrix.length][matrix[0].length] ;
        helper2(matrix, 3, 3, cache);
        System.out.println();
    }
    /**
     * O(n^2) 时间复杂度的算法
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    private static int helper1 (int[][] matrix, int i, int j) {
        if (i == 0 ) {
            if (j == 0) {
                return matrix[0][0] ;
            }else
                return helper1(matrix, i, j - 1) + matrix[i][j] ;
        }else if (j == 0) {
            return helper1(matrix, i - 1, j) + matrix[i][j] ;
        }else {
            return Math.min(helper1(matrix, i - 1, j), helper1(matrix, i, j - 1)) + matrix[i][j] ;
        }
    }

    /**
     * 时间复杂度为 O(n) 的算法
     */
    private static void helper2 (int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] == 0 ) {
            if (i == 0) {
                if (j == 0){
                    cache[0][0] = matrix[0][0] ;
                }else {
                    helper2(matrix, i, j - 1, cache);
                    cache[i][j] = cache[i][j - 1] + matrix[i][j] ;
                }
                return ;
            }else if (j == 0) {
                helper2(matrix, i - 1, j, cache);
                cache[i][j] = cache[i - 1][j] + matrix[i][j] ;
                return ;
            }else {
                helper2(matrix, i - 1, j, cache) ;
                helper2(matrix, i, j - 1, cache) ;
                cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + matrix[i][j] ;
            }
        }
    }

}
