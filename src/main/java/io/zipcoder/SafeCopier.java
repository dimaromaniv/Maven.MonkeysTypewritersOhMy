package io.zipcoder;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    private final Lock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        StringBuilder temp = new StringBuilder();
        while (stringIterator.hasNext()) {
            String word = stringIterator.next();
            lock.lock();

            try {
                temp.append(word).append(" ");
            } finally {
                lock.unlock();
            }
        }
        synchronized (this) {
            copied = temp.toString();
        }
    }
}
