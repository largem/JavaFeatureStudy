package com.study.java14.language;

public class StudySwitchExpression {
    public static void study() {
        System.out.println(studyConcept1(0));
        System.out.println(studyConcept1(2));

        System.out.println(studyConcept2(0));
        System.out.println(studyConcept2(2));

        System.out.println(studyConcept3(0));
        System.out.println(studyConcept3(2));
    }

    private static String studyConcept1(int day) {
        // act like an expression
        // multiple labels
        // single statement in each branch, using '->'
        final String result = switch (day) {
            case 1, 2, 3, 4, 5 -> "Work Day";
            case 6, 7 -> "weekend";
            default -> "invalid";
        };

        return result;
    }

    private static String studyConcept2(int day) {
        // use ":" with yield
        final String result = switch (day) {
            case 1, 2:      //yield will stop further
            case 3, 4, 5:
                yield "Work Day";
            case 6, 7:
                yield "weekend";
            default:
                yield "invalid";
        };

        return result;
    }

    private static String studyConcept3(int day) {
        // multiple statements in each case
        final String result = switch (day) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("Work Day");
                yield "work day";
            }
            case 6, 7 -> "weekend";
            default -> "invalid";
        };

        return result;
    }
}
