package com.study.java8.stream;

import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StudyReduceTest {

    @Test
    public void testReduce1_simple() {
        //Optional<T> reduce(BinaryOperator<T> accumulator)
        //The argument is BinaryOperator, need two elements from stream to be called.
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

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
    public void testReduce1_complex() {
        // reduce is immutable, create new element on each call (comparing with collect)

    }

    @Test
    public void testReducer2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = integerStream.reduce(0, Integer::sum);
        assertEquals(45, sum);

        integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        sum = integerStream.reduce(10, Integer::sum);
        //identity is not initial value, even the above sum gets the right value (55), does not mean it is correct.
        //identify must be satisfy the following, for any x, identity op x = x. op is the operation in reducer.
        assertEquals(55, sum);

        integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        sum = integerStream.parallel().reduce(10, (a, b) -> {
            System.out.printf("Thread: %d, %d + %d%n", Thread.currentThread().getId(), a, b);
            return a + b;
        });
        //this parallel stream will give 135, 10 will add to each of the number in the stream.
        assertNotEquals(55, sum);
    }

    @Test
    public void testReduce3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //if not parallel stream, combiner will not be called.
        String str = integerStream.reduce("", (a, b) -> String.format("%s%d", a, b), (s1, s2) -> s1 + s2);
        assertEquals("123456789", str);

        integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //in parallel stream, accumulator is applying identity to each element, combiner is doing the concatenation.
        //accumulator is also doing the map (type change).
        str = integerStream.parallel().reduce("",
                (a, b) -> {
                    System.out.printf("Thread %d, %s + %d%n", Thread.currentThread().getId(), a, b);
                    return String.format("%s%d", a, b);
                },
                (s1, s2) -> {
                    System.out.printf("Thread %d: %s + %s%n", Thread.currentThread().getId(), s1, s2);
                    return s1 + s2;
                });
        assertEquals("123456789", str);
    }

    @Test
    public void testOtherPredefinedReducers() {
        assertEquals(0, IntStream.of(0, 1, 2).min().orElse(0));
        assertEquals(2, IntStream.of(0, 1, 2).max().orElse(0));
        assertEquals(3, IntStream.of(0, 1, 2).count());
        assertEquals(3, IntStream.of(0, 1, 2).sum());
        assertEquals(1.0, IntStream.of(0, 1, 2).average().orElse(0.0), 0.0);

        IntSummaryStatistics iss = IntStream.of(0, 1, 2).summaryStatistics();
        assertEquals(0, iss.getMin());
        assertEquals(2, iss.getMax());
        assertEquals(3, iss.getCount());
        assertEquals(3, iss.getSum());
        assertEquals(1.0, iss.getAverage(), 0.0);
    }
}