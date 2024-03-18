package com.anzj.applet.messagequeue;

/**
 * @author anzj
 * @date 2022/7/17 19:03
 */
public class ProductFactory {

    public static void main(String[] args) {

        ProductQueue<String> products = new ProductQueue();
        Thread t1 = new Thread(new Producer<>(products,"a"),"生产者1");
        Thread t2 = new Thread(new Producer<>(products,"b"),"生产者2");
        Thread t3 = new Thread(new Producer<>(products,"c"),"生产者3");
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        products.getAll();
    }
}
