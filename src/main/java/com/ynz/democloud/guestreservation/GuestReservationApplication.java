package com.ynz.democloud.guestreservation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GuestReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestReservationApplication.class, args);

    }
}
