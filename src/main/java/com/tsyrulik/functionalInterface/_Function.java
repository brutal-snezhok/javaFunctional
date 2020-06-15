package com.tsyrulik.functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multipleBy10Function);

        System.out.println(addBy1AndThenMultiplyBy10.apply(2));
    }

    private static Function<Integer, Integer> multipleBy10Function = number -> number * 10;

    private static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    private static int incrementByOne(int number) {
        return number + 1;
    }
}
