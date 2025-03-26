package com.practice.poc.CustomImmutable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableTest {

    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        addresses.add("Hyderabad");
        addresses.add("Atp");
        addresses.add("Bangalore");
        CustomImmutable immutable = new CustomImmutable("Siva", addresses);
        List<String> addresses1 = immutable.getAddresses();
        addresses1.add("Xyz");
        System.out.println(addresses1);
    }
}
