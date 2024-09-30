package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NameBuilder {

    private String firstName;
    private String lastName;

    @Value("${app.default.firstName}")
    public String firstNameConfig;

    @Value("${feature.fp}")
    public String fP;

    // Autowire NamePrinter
    private final NamePrinter namePrinter;

    // Constructor injection of NamePrinter
    @Autowired
    public NameBuilder(NamePrinter namePrinter) {
        this.namePrinter = namePrinter;
    }

    public NameBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public NameBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String build() {
        // Use the injected NamePrinter
        namePrinter.printName(firstName);
        return firstName + " " + lastName + " ==firstNameConfig===" + firstNameConfig + "Featuer fp value=" + fP;
    }
}
