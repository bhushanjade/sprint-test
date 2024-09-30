package com.example.demo;

import com.example.utils.NameBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${app.default.firstName}")
    private String firstName;

    // Constructor injection without @Autowired
    private final NameBuilder nameBuilder;

    public DemoController(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;  // Dependency is injected by Spring through the constructor
    }

    @GetMapping("/api/print-name")
    public String printName() {
        // Use the injected NameBuilder
        String name = nameBuilder.withFirstName("John").withLastName("Doe").build();
        return "Printed Name: " + name + " name from config: " + firstName;
    }
}
