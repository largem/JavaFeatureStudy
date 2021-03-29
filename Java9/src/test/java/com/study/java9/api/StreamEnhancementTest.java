package com.study.java9.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamEnhancementTest {

    @Test
    public void testStreamTakeWhile() {
        // take any element until the predicate returns true
        String[] fruits = {"apple", "banana", "orange", "mango", "peach"};
        Stream<String> stream = Arrays.stream(fruits).takeWhile(s -> !"orange".equals(s));
        assertEquals(List.of("apple", "banana"), stream.collect(Collectors.toList()));
    }

    @Test
    public void testStreamDropWhile() {
        // drop all elements until the predicate returns false
        String[] fruits = {"apple", "banana", "orange", "mango", "peach"};
        Stream<String> stream = Arrays.stream(fruits).dropWhile(s -> !"orange".equals(s));
        assertEquals(List.of("orange", "mango", "peach"), stream.collect(Collectors.toList()));
    }


}