package com.yuki.common.util;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullSafeIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;
    private T[] array;
    private boolean isArray;

    public NullSafeIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public NullSafeIterable(T[] array) {
        this.array = array;
        this.isArray = true;
    }

    public Iterator<T> iterator() {
        if (this.isArray) {
            return this.array == null ? new NullSafeIterator() : Arrays.asList(this.array).iterator();
        } else {
            return this.iterable == null ? new NullSafeIterator() : this.iterable.iterator();
        }
    }

    public class NullSafeIterator implements Iterator<T> {
        public NullSafeIterator() {
        }

        public boolean hasNext() {
            return false;
        }

        public T next() {
            throw new NoSuchElementException("无数据");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
