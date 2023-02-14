package com.anzj.multiThreadApp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anzj
 * @date 2022/7/17 9:57
 *
 * 基于双端单链表实现队列，当多线程操作时为保证线程安全加锁处理
 * 为实现队列FIFO操作,采用链表尾插入数据，链表头删除数据
 * 当链表尾删除数据时需要知道尾节点前一个元素单链表无法指向前一个元素(故采用头删尾插)
 */
public class ProductQueue<E> {

    private Node first;//指向头节点
    private Node last;//指向尾节点
    Lock queueLock = new ReentrantLock();
    Condition full = queueLock.newCondition();

    public ProductQueue(){
        first = null;
        last = null;
    }
    //判断当前链表是否为空链表
    public boolean isEmpty(){
        return first == null;
    }
    //向链表尾节点插入数据（采用头插时尾节点始终保持不变，所以只需再插入第一个元素时指定尾节点）
    //为当前队列对象创建可重入锁来保证多个线程插入商品是的一致性、安全性
    public void insertLast(E e){
        queueLock.lock();
        try{
            Node<E> newNode = new Node(e);
            if(isEmpty())
                first = newNode;
            else
                last.next = newNode;
            last = newNode;
        }catch(Exception exception){
            exception.printStackTrace();
        }finally {
            queueLock.unlock();
        }

    }
    //实现队列采用头删尾插
    public void deleteFirst(){
        if(first.next == null) //当链表中仅有一个元素时需要将其尾节点指针删除
            last = null;
        first = first.next;
    }
    public void getAll(){
        Node curr = first;
        int size = 0;
        while(curr != null){
            System.out.println(curr.data.toString());
            curr = curr.next;
            ++size;
        }
        System.out.println("队列中共包含"+size+"个商品");
    }
    class Node<E>{
        E data;
        Node next;

        public Node(E e){
            this.data = e;
        }
    }

    public static void main(String[] args) {
        ProductQueue<String> products = new ProductQueue();
        products.insertLast("a");
        products.insertLast("b");
        products.getAll();
    }
}
