package com.study.java8.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class StudyOptionalAdvanced {
    public static void study() {
        System.out.println("Empty String" + handleIfElseLogic(() -> null));
        System.out.println("Double a: "+ handleIfElseLogic(() -> "a"));
        System.out.println("Triple b: "+ handleIfElseLogic(() -> "b"));
    }

    private static String handleIfElseLogic(Supplier<String> supplier) {
        /**
         * if optional is empty change to empty string
         * if optional has value a, double it
         * or else triple it
         */
        final Optional<String> opt = Optional.ofNullable(supplier.get());
        return opt
                .filter(v -> v.equals("a"))
                .map(v -> v + v)
                .orElse(opt.map(v -> v + v + v).orElse(""));
    }
}
