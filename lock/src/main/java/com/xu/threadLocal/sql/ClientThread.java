package com.xu.threadLocal.sql;

/**
 * Created by xu on 2015/6/5.
 */
public class ClientThread extends Thread{

    private ProductService productService;

    public ClientThread(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(1,3500);
    }

}
