package com.tsyrulik.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tsyrulik.stream.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }
        for(Person female : females) {
            System.out.println(female);
        }

        // Declarative approach

        System.out.println("\nFilter: ");
        people.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .forEach(System.out::println);

        System.out.println("\nSort by age then by name: ");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("\nAll match that have have age > 5: ");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);

        System.out.println("\nAny match that have have age > 8: ");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        System.out.println(anyMatch);

        System.out.println("\nNone match that have have age > 100: ");
        boolean noneMatch = people.stream()
                .allMatch(person -> person.getAge() > 100);
        System.out.println(noneMatch);

        System.out.println("\nMax age: ");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("\nMin: ");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("\nGroup by gender: ");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen White", 57, FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, FEMALE),
                new Person("Zelda Brown", 120, FEMALE)
        );
    }
}
