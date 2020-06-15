package com.tsyrulik.finalSection;

import java.util.function.Consumer;

public class Callback {
    public static void main(String[] args) {

        hello("John", "Montana", value -> System.out.println("no lastName provided for " + value));
        System.out.println("*************");
        hello("John", null, value -> System.out.println("no lastName provided for " + value));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if(lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }
}
