package com.tutotial.dmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.tutotial.dmn.**", "org.kie.kogito.**", "https**", "com_46tutorial_46dmn**" })
public class KogitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KogitoApplication.class, args);
    }

}