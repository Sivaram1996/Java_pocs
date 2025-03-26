package com.practice.poc.CustomImmutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class CustomImmutable {

    private final String name;

    private final List<String> addresses;

    public CustomImmutable(String name, List<String> addresses) {
        this.name = name;
        this.addresses = Collections.unmodifiableList(new ArrayList<>(addresses));
    }

    public String getName() {
        return name;
    }

    public List<String> getAddresses() {
        return addresses;
    }
}
