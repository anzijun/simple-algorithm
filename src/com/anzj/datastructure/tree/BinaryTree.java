package com.anzj.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * @Author anzj
 * @Date 2024/3/17
 */

public class BinaryTree {
    //树的根节点
    private Node root;

    public BinaryTree(Node root){
        this.root = root;
    }
    /**
     * 二叉树前序遍历
     */
    public void preOrder(){
        if(root != null)
            root.preOrder();
    }
    /**
     * 二叉树中序遍历
     */
    public void minOrder(){
        if (root != null)
            root.minOrder();
    }
    /**
     * 二叉树后序遍历
     */
    public void postOrder(){
        if (root != null)
            root.postOrder();
    }
    /**
     * 获取二叉树所有路径
     * @Param path--遍历到当前的路径
     * @Param pathList--存放所有路径
     */
    public void everyPath(Node root, List<Integer> currentPath, List<List<Integer>> allPathList){
        if (root == null)
            return;
        List<Integer> newCurrentPath = new ArrayList<>(currentPath);
        newCurrentPath.add(root.data);
        if (root.left == null && root.right == null){
            //no child,iterate end
            allPathList.add(newCurrentPath);
        }else{
            //has child,go on
            everyPath(root.left,newCurrentPath,allPathList);
            everyPath(root.right,newCurrentPath,allPathList);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.left = left;
        root.right = right;
        left.left = node4;
        left.right = node5;
        BinaryTree tree = new BinaryTree(root);
/*        System.out.println("前序结果：");
        tree.preOrder();
        System.out.println("\r\n中序结果：");
        tree.minOrder();
        System.out.println("\r\n后序结果：");
        tree.postOrder();*/

        List<List<Integer>> paths = new ArrayList<>();
        tree.everyPath(tree.root,new ArrayList<>(),paths);
        for (List<Integer> path : paths){
            int pathSum = 0;
            StringBuilder pathString = new StringBuilder();
            for (Integer value : path){
                pathSum += value;
                pathString.append(value + "-->");
            }
            System.out.println("路径：" + pathString + "和为：" + pathSum);
        }
    }

    static final class Node{
        private int data;//数据
        private Node left;//左子节点
        private Node right;//右子节点

        Node(int data){
            this.data = data;
        }

        /**
         * 前序遍历:根-->左-->右
         */
        public void preOrder(){
            System.out.print(this.data+" ");
            if(this.left != null)
                this.left.preOrder();
            if (this.right != null)
                this.right.preOrder();
        }
        /**
         * 中序遍历:左-->根-->右
         * @return
         */
        public void minOrder(){
            if (this.left != null)
                this.left.minOrder();
            System.out.print(this.data+" ");
            if (this.right != null)
                this.right.minOrder();
        }
        /**
         * 后序遍历:左-->右-->根
         */
        public void postOrder(){
            if(this.left != null)
                this.left.postOrder();
            if (this.right != null)
                this.right.postOrder();
            System.out.print(this.data+" ");
        }




        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
