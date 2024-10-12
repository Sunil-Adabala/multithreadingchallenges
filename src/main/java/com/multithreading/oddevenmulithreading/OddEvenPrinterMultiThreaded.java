package com.multithreading.oddevenmulithreading;
import java.util.logging.Logger;
import java.util.logging.Level;


public class OddEvenPrinterMultiThreaded {
    private static final Logger logger = Logger.getLogger(OddEvenPrinterMultiThreaded.class.getName());

    private int number;
    private boolean oddTurn;
    private final int upperLimit;

    public OddEvenPrinterMultiThreaded(int upperLimit){
        this.upperLimit = upperLimit;
        this.oddTurn = true;
        this.number = 1;
    }

    public synchronized void printOddNumber() throws InterruptedException {
        logger.log(Level.INFO, "Starting new thread to print odd numbers, Thread id -> {0}", Thread.currentThread().threadId());
        while (number < this.upperLimit){
            while (!oddTurn){
                wait();
            }

            logger.log(Level.INFO, "Odd : {0}",getNumber());
            incrementNumber();
            oddTurn = false;

            notify();
        }
        logger.log(Level.INFO, "Thread id -> {0} ended ", Thread.currentThread().threadId());
    }


    public synchronized void printEvenNumber() throws InterruptedException {
        logger.log(Level.INFO, "Starting new thread to print even numbers, Thread id -> {0}", Thread.currentThread().threadId());
        while (number < this.upperLimit){
            while (oddTurn){
                wait();
            }
            logger.log(Level.INFO, "Odd : {0}",getNumber());
            incrementNumber();
            oddTurn = true;
            notify();
        }
        logger.log(Level.INFO, "Thread id -> {0} ended ", Thread.currentThread().threadId());
    }

    private void incrementNumber(){
        this.number++;
    }

    private int getNumber(){
        return this.number;
    }


}
