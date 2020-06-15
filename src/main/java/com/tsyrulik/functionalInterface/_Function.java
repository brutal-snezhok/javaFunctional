package com.tsyrulik.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multipleBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(2));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(1, 10));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(1, 10));
    }

    private static Function<Integer, Integer> multipleBy10Function = number -> number * 10;

    private static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    private static int incrementByOne(int number) {
        return number + 1;
    }

    private static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    private static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
