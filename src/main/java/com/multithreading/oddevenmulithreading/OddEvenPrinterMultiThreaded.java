package com.multithreading.oddevenmulithreading;
import java.util.logging.Logger;
import java.util.logging.Level;


public class OddEvenPrinterMultiThreaded {
    // Logger instance for logging events in the multi-threaded class
    private static final Logger logger = Logger.getLogger(OddEvenPrinterMultiThreaded.class.getName());

    private int number;
    private boolean oddTurn;
    private final int upperLimit;

    public OddEvenPrinterMultiThreaded(int upperLimit){
        this.upperLimit = upperLimit;
        this.oddTurn = true;
        this.number = 1;
    }

    // Method for printing odd numbers
    public synchronized void printOddNumber() throws InterruptedException {
        logger.log(Level.INFO, "Starting new thread to print odd numbers, Thread id -> {0}", Thread.currentThread().threadId());
        while (number < this.upperLimit){
            while (!oddTurn){
                wait();  // Wait if it's not odd's turn
            }

            logger.log(Level.INFO, "Odd : {0}",getNumber());
            incrementNumber();
            setTurn(false);// Now it's even's turn

            notify(); // Notify waiting thread
        }
        logger.log(Level.INFO, "Thread id -> {0} ended ", Thread.currentThread().threadId());
    }

    // Method for printing even numbers
    public synchronized void printEvenNumber() throws InterruptedException {
        logger.log(Level.INFO, "Starting new thread to print even numbers, Thread id -> {0}", Thread.currentThread().threadId());
        while (number < this.upperLimit){
            while (oddTurn){
                wait(); // Wait if it's not even's turn
            }
            logger.log(Level.INFO, "Odd : {0}",getNumber());
            incrementNumber();
            setTurn(true);// Now it's odd's turn
            notify();  // Notify waiting thread
        }
        logger.log(Level.INFO, "Thread id -> {0} ended ", Thread.currentThread().threadId());
    }

    private void setTurn(boolean oddTurn){
        this.oddTurn = oddTurn;
    }

    private void incrementNumber(){
        this.number++;
    }

    private int getNumber(){
        return this.number;
    }


}
