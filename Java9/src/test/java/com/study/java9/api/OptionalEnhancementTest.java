package com.study.java9.api;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class OptionalEnhancementTest {

    @Test
    public void optionalIfPresentOrElse(){
        //IfPresentOrElse provides both possitive and negative handling to avoid if-else statement in Java 8 Optional
        IntStream.of(1, 2, 4)
                .filter(i -> i % 3 == 0)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No multiple of 3 found"));
        IntStream.of(2, 6, 8)
                .filter(i -> i % 3 == 0)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No multiple of 3 found"));

    }
}