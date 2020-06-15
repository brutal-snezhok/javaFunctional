package com.tsyrulik.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailIsValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberIsValid(String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer) {
        return isEmailIsValid(customer.getEmail()) &&
               isPhoneNumberIsValid(customer.getPhoneNumber()) &&
               isAdult(customer.getDob());
    }
}
