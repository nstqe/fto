package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrokiTest {

    @Test
    public void copyStringNTimes() {
        String s = "s";
        String N = "4";
        String expected = "ssss";
        String actual = Stroki.dopMeted(s, N);
        assertEquals(expected, actual);
    }
    @Test
    public void copyStringNTimes2() {
        String s = "s";
        String N = "-1";
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.dopMeted(s, N);
        });
    }
    @Test
    public void copyStringNTimes3() {
        String s = "s";
        String N = "0";
        String expected = "";
        String actual = Stroki.dopMeted(s,N);
        assertEquals(expected,actual);
    }

    @Test
    public void findSecondInFirst() {
        String str1 = "люблю бананы";
        String str2 = "бананы";
        String expected = "6";
        String actual = String.valueOf(Stroki.meted(str1, str2));
        assertEquals(expected, actual);
    }
    @Test
    public void findSecondInFirst2() {
        String str1 = "люблю бананы";
        String str2 = "4";
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.meted(str1, str2);
        });
    }
    @Test
    public void findSecondInFirst3() {
        String str1 = "люблю бананы";
        String str2 = "null";
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.meted(str1, str2);
        });
    }
    @Test
    public void findSecondInFirst4() {
        String str1 = "люблю бананы";
        String str2 = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.meted(str1, str2);
        });
    }

    @Test
    public void stroki123() {
        String input = "123";
        String expected = "одиндватри";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki123Exception() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.replaceNumbers(input);
        });
    }@Test
    public void stroki123Exception2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Stroki.replaceNumbers(null);
        });
    }
    @Test
    public void stroki123two() {
        String input = "12345";
        String expected = "одиндватри45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1233() {
        String input = "1235";
        String expected = "одиндватри5";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void stroki1234() {
        String input = "23";
        String expected = "дватри";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1235() {
        String input = "13";
        String expected = "одинтри";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1236() {
        String input = "12";
        String expected = "одиндва";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1237() {
        String input = "12345";
        String expected = "одиндватри45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1238() {
        String input = "245";
        String expected = "два45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki1239() {
        String input = "45";
        String expected = "45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki12310() {
        String input = "1345";
        String expected = "одинтри45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki12311() {
        String input = "145";
        String expected = "один45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void stroki12312() {
        String input = "345";
        String expected = "три45";
        String actual = Stroki.replaceNumbers(input);
        assertEquals(expected, actual);
    }
    @Test
    public void deleteTwo() {
        StringBuilder str = new StringBuilder("бочка");
        String expected = "бча";
        String actual = Stroki.deleteTwoInsert(str).toString();
        assertEquals(expected, actual);
    }
    @Test
    public void deleteTwo1() {
        assertThrows(IllegalArgumentException.class, () -> Stroki.deleteTwoInsert(new StringBuilder()));
    }
    @Test
    public void deleteTwo2() {
        assertThrows(IllegalArgumentException.class, () -> Stroki.deleteTwoInsert(null));
    }
    @Test
    public void deleteTwo3() {
        StringBuilder str = new StringBuilder("a");
        StringBuilder result =Stroki.deleteTwoInsert(str);
        assertEquals("a", result.toString());
    }
}