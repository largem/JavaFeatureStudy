package com.study.java11.api;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StudyOptionalApis {
    @Test
    public void studyOptional_isEmpty() {
        //isEmpty is the opposite of isPresent

        Optional<Integer> result = Stream.of(1, 2, 3, 4).filter(n -> n>4).findFirst();
        assertTrue(result.isEmpty());
        assertFalse(result.isPresent());
    }
}
