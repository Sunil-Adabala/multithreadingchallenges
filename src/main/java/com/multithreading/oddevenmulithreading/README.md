# OddEven Multithreading Challenge

This Java project demonstrates a multithreading challenge where two threads print odd and even numbers alternatively until an upper limit is reached. Once the upper limit is hit, both threads stop gracefully.

## Overview

The project contains two classes:
- `OddEvenPrinter`: The main class that initializes the multithreading logic and manages two threads for printing odd and even numbers.
- `OddEvenPrinterMultiThreaded`: A class that encapsulates the logic for alternating between odd and even number printing.

The program utilizes Java's `synchronized` methods, `wait()`, and `notifyAll()` for proper thread synchronization. Additionally, logging is used via `java.util.logging` to record the thread activities instead of `System.out.println`.

## How It Works

1. The `OddEvenPrinter` class initializes two threads: one for printing odd numbers and one for printing even numbers.
2. The `OddEvenPrinterMultiThreaded` class handles the alternating printing of odd and even numbers using a shared state (`isOddTurn`).
3. The threads use a `synchronized` block to ensure that only one thread prints at a time.
4. The `wait()` and `notifyAll()` methods ensure that threads wait for their turn to print and notify each other when they are done.

## Logging

The project uses the `java.util.logging.Logger` for logging messages instead of using `System.out.println`. You can view log messages at the `INFO` level for both odd and even number printing.

## Requirements

- Java 8 or higher
- A Java IDE or text editor with support for compiling and running Java programs.

## Running the Application

1. Clone this repository.
2. Open the project in your IDE or compile using the command line.
3. Run the `OddEvenPrinter` class to start the program.
4. The application will print odd and even numbers alternately in the console, and once the upper limit is reached, it will stop gracefully.

## Project Structure

