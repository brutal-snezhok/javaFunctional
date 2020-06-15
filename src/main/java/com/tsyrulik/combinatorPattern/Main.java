package com.tsyrulik.combinatorPattern;

import java.time.LocalDate;

import static com.tsyrulik.combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+089878787878",
                LocalDate.of(2000, 1, 1));

       // System.out.println(new CustomerValidatorService().isValid(customer));

        //Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}