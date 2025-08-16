
package com.example.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UberRideProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UberRideProducerApplication.class, args);
    }
}

//zookeeper-server-start.bat ..\..\config\zookeeper.properties
//kafka-server-start.bat ..\..\config\server.properties
//kafka-topics.bat --create --topic uber-rides --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1