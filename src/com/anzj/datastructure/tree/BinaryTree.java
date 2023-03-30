package com.anzj.datastructure.tree;

/**
 * 二叉树
 */
public class BinaryTree{

    private Node root;//二叉树的根节点

    public BinaryTree(){
        root = null;
    }

    /**
     * 新增节点
     */
    public void insert(int data){

    }

    /**
     * 删除节点
     */
    public void delete(){

    }

    /**
     * 查找节点
     */
    public Node find(int key){
        Node current = root;
        if(current == null)
            return null;
        while(current.data != key){
            //树中当前节点得值不为要查找的目标值时，继续查看当前节点的左子树和右子树
            if(key < current.data){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current == null)
                return null;
        }
        return current;
    }

}

class Node{

    int data;
    Node leftChild;
    Node rightChild;

    public Node(){
    }

}