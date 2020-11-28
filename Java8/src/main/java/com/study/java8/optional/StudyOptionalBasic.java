package com.study.java8.optional;

import com.stufy.common.CommonUtil;

import java.util.Optional;
import java.util.function.Consumer;

public class StudyOptionalBasic {

    public static void study() {
        System.out.println(StudyOptionalBasic.class.getName());

        final Optional<String> optionalWithValue = optionalIsForReturn(true);
        final Optional<String> emptyOptional = optionalIsForReturn(false);

        // convert Optional value
        int stringLength = optionalWithValue.map(String::length).orElse(0);
        // provide default value for an empty optional
        String defaultValue = emptyOptional.orElse("DefaultValue");
        // provide default value from heavy operation
        String defaultValueFromOp = emptyOptional.orElseGet(StudyOptionalBasic::calculateValue);

        //consuming optional
        optionalWithValue.ifPresent(System.out::println);

        //get the value from non-empty optional, not recommended (using functional style above is better.
        if (optionalWithValue.isPresent()) {
            System.out.println(optionalWithValue.get());
        }

        //throw exception when empty (error handling)
        try {
            emptyOptional.orElseThrow(() -> new RuntimeException("empty optional can not be handled"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //filter
        final String filteredValue = optionalWithValue.filter(v -> v.contains("a")).orElse("");
        CommonUtil.BLACK_HOLE.accept(filteredValue);

        //flatmap : map the optional to its value
        final String valueFromFlatmap = optionalWithValue.flatMap(StudyOptionalBasic::optionalIsForReturn_fromNullable).orElse("");
        CommonUtil.BLACK_HOLE.accept(valueFromFlatmap);
    }

    private static String calculateValue() {
        //assume this take very long
        return "value from heavy calculation";
    }

    private static Optional<String> optionalIsForReturn(boolean cond) {
        return cond ? Optional.of("Value") : Optional.empty();
    }

    private static Optional<String> optionalIsForReturn_fromNullable(String input) {
        return Optional.ofNullable(input);      //create an optional from a nullable value
    }
}

