package com.xu.lock;

/**
 * Created by xu on 2015/6/4.
 */
public class ReadWriteLock {
    private int readThreadCounter = 0;  //���ڶ�ȡ���߳�����0��������
    private int wattingWriteCounter = 0;    //���ڵȴ�д����߳�����0��������
    private int writeThreadCounter = 0; //����д����߳�����0����1����
    private boolean writeFlag = true;   //�Ƿ��д�����ȣ�Ĭ��Ϊ�ǣ�

    //��ȡ����
    public synchronized void readLock() throws InterruptedException {
        while (writeThreadCounter > 0 || (writeFlag && wattingWriteCounter > 0)){
            wait();
        }
        //ʹ���ڶ�ȡ���߳�����һ
        readThreadCounter++;
    }

    //��ȡ����
    public synchronized void readUnlock(){
        //ʹ���ڶ�ȡ���߳�����һ
        readThreadCounter--;
        //��ȡ��������д������
        writeFlag = true;
        //֪ͨ���д���wait״̬���߳�
        notifyAll();
    }

    //д�����
    public synchronized void writeLock() throws InterruptedException {
        //ʹ�ȴ�д����߳�����һ
        wattingWriteCounter++;
        try {
            //���������ڶ�ȡ���߳��������������д����̣߳��򽫵�ǰ�߳�����Ϊ�ȴ�״̬
            while (readThreadCounter > 0 || writeThreadCounter > 0)
                wait();
        }finally {

        }
    }
}
