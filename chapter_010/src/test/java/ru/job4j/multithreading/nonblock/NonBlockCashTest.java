package ru.job4j.multithreading.nonblock;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;

public class NonBlockCashTest {
    @Test
    public void whenThrowException() throws InterruptedException {
        ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();
        NonBlockCash cash = new NonBlockCash(map);
        Base base1 = new Base(1, 0);
        cash.add(base1);
        AtomicReference<OptimisticException> ex = new AtomicReference<>();
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cash.update(new Base(1, 1));
                    } catch (OptimisticException op) {
                        ex.set(op);
                    }
                }
        );
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(() -> {
            try {
                cash.update(new Base(1, 1));
            } catch (OptimisticException op) {
                ex.set(op);
            }

        });
        thread2.start();
        thread2.join();
        Assert.assertThat(ex.get().getMessage(), is("Версия не совпадает!"));
    }
}