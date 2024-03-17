package com.anzj.datastructure.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    private Node root;//二叉树的根节点

    public BinarySearchTree(){
        root = null;
    }

    /**
     * 新增节点
     */
    public void insert(int data){
        Node newOne = new Node();
        newOne.data = data;
        if(root == null) {
            root = newOne;
        }else {
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(data < current.data){
                    //如果要插入的数据小于当前节点数据则 继续查看左子树
                    current = current.leftChild;
                    if(current == null){
                        //如果左子树为空
                        parent.leftChild = newOne;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newOne;
                        return;
                    }
                }
            }
        }
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

    /**
     * 前序遍历二叉搜索树
     */
    public void preOrder(){

    }

    /**
     * 中序遍历二叉树
     */
    public void inOrder(){

    }

    /**
     * 后序遍历
     */
    public void postOrder(){

    }
}

class Node{

    int data;
    Node leftChild;
    Node rightChild;

    public Node(){
    }

}