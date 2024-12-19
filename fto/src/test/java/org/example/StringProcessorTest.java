package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    @Test
    void testReverseWords_NullInput() {
        StringProcessor processor = new StringProcessor();
        assertThrows(IllegalArgumentException.class, () -> {
            processor.reverseWords(null);
        });
    }
}
