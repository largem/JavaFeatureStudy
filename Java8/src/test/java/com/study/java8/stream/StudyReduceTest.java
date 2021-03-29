package com.study.java8.stream;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StudyReduceTest {

    @Test
    public void testReduce1_simple() {
        //Optional<T> reduce(BinaryOperator<T> accumulator)
        //The argument is BinaryOperator, need two elements from stream to be called.
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,7,8,9);

        // (a, b) -> a+b;
        int sum = integerStream.reduce(Integer::sum).orElse(0);
        assertEquals(45, sum);

        IntStream emptyInStream = IntStream.of();
        //accumulator is not called, and return Optional.empty()
        sum = emptyInStream.reduce(Integer::sum).orElse(0);
        assertEquals(0, sum);

        IntStream singleIntStream = IntStream.of(1);
        //accumulator is not called, and return Optional.of(<first element>)
        sum = singleIntStream.reduce((a, b) -> 99999 /* not be called */).orElse(0);
        assertEquals(1, sum);
    }

    @Test
    public void testReducer2() {

    }

}