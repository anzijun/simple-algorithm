package com.anzj.multiThreadApp;

import java.beans.PropertyDescriptor;

/**
 * @author anzj
 * @date 2022/7/17 11:00
 */
public class Producer<E> implements Runnable{

    ProductQueue productQueue;
    E e;

    public Producer(ProductQueue queue,E e){
        this.productQueue = queue;
        this.e = e;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在插入元素");
        productQueue.insertLast(e);
    }
}
