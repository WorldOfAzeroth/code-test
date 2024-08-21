package org.codetest;

public class SimpleConsecutiveLetterScanner implements ConsecutiveLetterScanner {

    private final StringBuilder buff;
    private final int[] marker;
    private int index;

    public SimpleConsecutiveLetterScanner(String consecutiveLetter) {
        this.buff = new StringBuilder(consecutiveLetter);
        this.marker = new int[consecutiveLetter.length()];
    }

    @Override
    public boolean hasNext() {
        for (; index < buff.length(); index++) {
            if (index == 0 || buff.charAt(index) != buff.charAt(index - 1)) {
                marker[index] = 1;
            } else {
                marker[index] = marker[index - 1] + 1;
                if (marker[index] > 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void remove() {
        buff.delete(index - marker[index] + 1, index + 1);
        index = index - marker[index] + 1;
    }

    @Override
    public void replace() {
        char repeatedChar = buff.charAt(index);
        buff.replace(index - marker[index] + 1, index + 1, repeatedChar == 'a' ? "" : String.valueOf((char) (repeatedChar - 1)));
        index = index - marker[index] + 1;
    }

    @Override
    public String get() {
        return buff.toString();
    }

}
