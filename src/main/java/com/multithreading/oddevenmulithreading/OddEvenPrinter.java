package com.multithreading.oddevenmulithreading;
import java.util.logging.Logger;
import java.util.logging.Level;


public class OddEvenPrinter {
    private static final Logger logger = Logger.getLogger(OddEvenPrinterMultiThreaded.class.getName());


    public static void main(String[] args) throws InterruptedException {
        OddEvenPrinterMultiThreaded oddEvenPrinter = new OddEvenPrinterMultiThreaded(1000);

        Thread oddPrinter = new Thread(() ->{
            try {
                oddEvenPrinter.printOddNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread evenPrinter = new Thread(() -> {
            try {
                oddEvenPrinter.printEvenNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        oddPrinter.start();
        evenPrinter.start();

        oddPrinter.join();
        evenPrinter.join();

        logger.log(Level.INFO, "Threads are now stopped, application stopped execution");

    }

}
