package io.fullstackexp.ppm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={ "io.fullstackexp.ppm"})
@Slf4j
public class PpmApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpmApplication.class, args);
    }
}
