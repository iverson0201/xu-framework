package com.xu.lock;

/**
 * Created by xu on 2015/6/4.
 */
public class ReadWriteLock {
    private int readThreadCounter = 0;  //正在读取的线程数（0个或多个）
    private int wattingWriteCounter = 0;    //正在等待写入的线程数（0个或多个）
    private int writeThreadCounter = 0; //正在写入的线程数（0个或1个）
    private boolean writeFlag = true;   //是否对写入优先（默认为是）

    //读取加锁
    public synchronized void readLock() throws InterruptedException {
        while (writeThreadCounter > 0 || (writeFlag && wattingWriteCounter > 0)){
            wait();
        }
        //使正在读取的线程数加一
        readThreadCounter++;
    }

    //读取解锁
    public synchronized void readUnlock(){
        //使正在读取的线程数减一
        readThreadCounter--;
        //读取结束，对写入优先
        writeFlag = true;
        //通知所有处于wait状态的线程
        notifyAll();
    }

    //写入加锁
    public synchronized void writeLock() throws InterruptedException {
        //使等待写入的线程数加一
        wattingWriteCounter++;
        try {
            //若存在正在读取的线程数，或存在正在写入的线程，则将当前线程数设为等待状态
            while (readThreadCounter > 0 || writeThreadCounter > 0)
                wait();
        }finally {

        }
    }
}
