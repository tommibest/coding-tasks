package com.zaras.concurency.synch;

public class Counter {

    private volatile int value;

    public Counter(int value) {
        if (value < 0) throw new ArithmeticException();
        this.value = value;
    }

    public synchronized int get() {
        return value;
    }

    public synchronized int getAndIncrement() {
        if (value == Integer.MAX_VALUE) throw new ArithmeticException("overflow");
        return value++;
    }

    public synchronized int incrementAndGet() {
        if (value == Integer.MAX_VALUE) throw new ArithmeticException("overflow");
        return ++value;
    }

    private static class CounterJ9 {
    }
}
