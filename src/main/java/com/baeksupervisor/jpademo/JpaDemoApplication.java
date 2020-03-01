package com.baeksupervisor.jpademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>> JpaDemoApplication Started. <<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
