package com.anzj.applet.messagequeue;

/**
 * @author anzj
 * @date 2022/7/17 11:02
 */
public class Consumer implements Runnable{

    ProductQueue productQueue;

    public Consumer(ProductQueue queue){
        this.productQueue = queue;
    }

    @Override
    public void run() {

    }
}
