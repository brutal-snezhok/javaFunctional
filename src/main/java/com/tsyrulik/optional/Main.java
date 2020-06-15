package com.tsyrulik.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value1 = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        Object value2 = Optional.ofNullable("hello")
                .orElseThrow(() -> new IllegalStateException("exception"));
        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        System.out.println("**************");

        Optional.ofNullable(null)
                .ifPresent(email -> System.out.println("Sending email to " + email));

        System.out.println("**************");

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        });
    }
}
