package org.codetest;


import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ConsecutiveLetterScannerTest {


    @Test
    public void testRemove() {

        Map<String,String> testData = Map.of(
                "aabcccbbad","d",
                "aaabcccbbad","ad",
                "deeedbbcccbdaa", "aa"
        );
        testData.forEach((key, value) -> {
            ConsecutiveLetterScanner scanner = new RegexpConsecutiveLetterScanner(key);
            while (scanner.hasNext()) {
                scanner.remove();
            }
            Assert.assertEquals(value, scanner.get());

        });
        testData.forEach((key, value) -> {
            ConsecutiveLetterScanner scanner = new SimpleConsecutiveLetterScanner(key);
            while (scanner.hasNext()) {
                scanner.remove();
            }
            Assert.assertEquals(value, scanner.get());

        });

    }


    @Test
    public void testReplace() {

        Map<String,String> testData = Map.of(
                "abcccbad","d"
        );
        testData.forEach((key, value) -> {
            ConsecutiveLetterScanner scanner = new RegexpConsecutiveLetterScanner(key);
            while (scanner.hasNext()) {
                scanner.replace();
            }
            Assert.assertEquals(value, scanner.get());

        });
        testData.forEach((key, value) -> {
            ConsecutiveLetterScanner scanner = new SimpleConsecutiveLetterScanner(key);
            while (scanner.hasNext()) {
                scanner.replace();
            }
            Assert.assertEquals(value, scanner.get());

        });

    }


}
