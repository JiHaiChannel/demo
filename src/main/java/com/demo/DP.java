package com.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:jihai
 * @Date:2022/8/16
 * @Description:
 */
public class DP {
    volatile static int state = 0; // 0,1,2 A,B,C
    volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        Condition printACondition = reentrantLock.newCondition();
        Condition printBCondition = reentrantLock.newCondition();
        Condition printCCondition = reentrantLock.newCondition();

        Thread t1 = new Thread(new PrintRunner(printACondition, printBCondition, 34, reentrantLock, 'A'), "1 ---");
        Thread t2 = new Thread(new PrintRunner(printBCondition, printCCondition, 33, reentrantLock, 'B'), "2 ---");
        Thread t3 = new Thread(new PrintRunner(printCCondition, printACondition, 33, reentrantLock, 'C'), "3 ---");

        t1.start();
        t2.start();
        t3.start();
    }


    static class PrintRunner implements Runnable {

        private Condition curCondition;
        private Condition nextCondition;
        private Integer count;
        private ReentrantLock reentrantLock;
        private Character character;

        public PrintRunner(Condition curCondition, Condition nextCondition, Integer count, ReentrantLock reentrantLock, Character character) {
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
            this.count = count;
            this.reentrantLock = reentrantLock;
            this.character = character;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                reentrantLock.lock();
                if (i ++ < count) {
                    System.out.println(Thread.currentThread() + " : " + character);

                    nextCondition.signal();
                    try {
                        curCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                reentrantLock.unlock();
            }
        }
    }



}
