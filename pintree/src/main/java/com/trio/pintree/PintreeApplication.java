package com.trio.pintree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.trio.pintree.login.*"})
public class PintreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PintreeApplication.class, args);
    }

}
