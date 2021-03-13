package com.stufy.common;

import java.util.function.Consumer;

public class CommonUtil {

    // consume any unused variable
    public static Consumer<Object> BLACK_HOLE = v -> {};

    public static void log(String message) {
        System.out.println(message);
    }
}
