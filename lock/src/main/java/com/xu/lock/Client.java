package com.xu.lock;

/**
 * Created by xu on 2015/6/4.
 */
public class Client {
    public static void main(String[] args) {
        Data data = new Data(10);

        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();

        new WriterThread(data,"ABCDEFGHI").start();
        new WriterThread(data,"0123456789").start();
    }
}
