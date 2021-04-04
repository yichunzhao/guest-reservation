package com.ynz.democloud.guestreservation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class GuestReservationApplication {

    public static void main(String[] args) {
        log.info("Reserving Room Micro_service: ");
        SpringApplication.run(GuestReservationApplication.class, args);
    }

}
