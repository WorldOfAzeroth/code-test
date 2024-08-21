package org.codetest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpConsecutiveLetterScanner implements ConsecutiveLetterScanner {


    private static final Pattern PATTERN = Pattern.compile("([a-z])\\1\\1", Pattern.CASE_INSENSITIVE);


    private String value;
    private Matcher matcher;


    public RegexpConsecutiveLetterScanner(String consecutiveLetter) {
        value = consecutiveLetter;
    }

    @Override
    public boolean hasNext() {
        matcher = PATTERN.matcher(value);
        return matcher.find();
    }

    @Override
    public void remove() {
        value = matcher.replaceFirst("");

    }

    @Override
    public void replace() {
        char repeated = matcher.group().charAt(0);
        value = repeated == 'a' ? matcher.replaceFirst("") : matcher.replaceFirst(String.valueOf((char) (repeated - 1)));
    }

    @Override
    public String get() {
        return value;
    }
}
