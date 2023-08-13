package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {

        super(toCopy);
    }

    public void run() {
        while (stringIterator.hasNext()) {
            StringBuilder temp = new StringBuilder();

            while (stringIterator.hasNext()) {
                String word = stringIterator.next();
                temp.append(word).append(" ");
            }
            copied = temp.toString();
        }
    }
}
