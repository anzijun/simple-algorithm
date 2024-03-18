package com.anzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author anzj
 *  @Date 2024/3/17
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class LeetCode112 {
    public static void main(String[] args) {
        int[] arr = {5,4,8,11,13,4,7,2,1};

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        List<List<Integer>> pathList = new ArrayList<>();
        getAllPath(root,new ArrayList<>(),pathList);
        for(List<Integer> path : pathList){
            int pathSum = 0;
            for(Integer val : path){
                pathSum += val;
            }
            if(targetSum == pathSum)
                return true;
        }
        return false;
    }
    /**
     * 深度优先遍历
     */
    public void getAllPath(TreeNode root,List<Integer> currentPath,List<List<Integer>> pathList){
        if(root == null)
            return;
        List<Integer> newCurrentPath = new ArrayList<>(currentPath);
        newCurrentPath.add(root.val);
        if(root.left == null && root.right == null){
            pathList.add(newCurrentPath);
        }else{
            getAllPath(root.left,newCurrentPath,pathList);
            getAllPath(root.right,newCurrentPath,pathList);
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}