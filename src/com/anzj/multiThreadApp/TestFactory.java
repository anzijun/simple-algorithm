package com.anzj.multiThreadApp;

/**
 * @author anzj
 * @date 2022/7/17 19:03
 */
public class TestFactory {

    public static void main(String[] args) throws  Exception{

        ProductQueue<String> products = new ProductQueue();
        Thread t1 = new Thread(new Producer<String>(products,"a"),"生产者1");
        Thread t2 = new Thread(new Producer<String>(products,"b"),"生产者2");
        Thread t3 = new Thread(new Producer<String>(products,"c"),"生产者3");
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
