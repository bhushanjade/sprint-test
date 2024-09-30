package com.example.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class NamePrinter {

    @Value("${feature.fp}")
    public String fP;

    public void printName(String name) {
        System.out.println("Name: " + name);
        System.out.println("fP from NamePrinter: " + fP);
    }
}
