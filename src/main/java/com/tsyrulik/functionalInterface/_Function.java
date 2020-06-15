package com.tsyrulik.functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
    }

    private static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    private static int incrementByOne(int number) {
        return number + 1;
    }
}
