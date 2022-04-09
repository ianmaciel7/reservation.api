package br.com.ucsal.reservation.api.models.persistence;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryList<T> extends ArrayList<T> {
    private final AtomicInteger current = new AtomicInteger(0);

    @Override
    public boolean add(T e) {
        return super.add(e);
    }

    public int autoIncrement() {
        return current.incrementAndGet();
    }

}
