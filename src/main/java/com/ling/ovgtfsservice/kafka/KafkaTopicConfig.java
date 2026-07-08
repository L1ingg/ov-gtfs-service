package com.ling.ovgtfsservice.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic gtfsRoutes() {
        return new NewTopic("gtfs.routes", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsStops() {
        return new NewTopic("gtfs.stops", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsStopTimes() {
        return new NewTopic("gtfs.stoptimes", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsTrips() {
        return new NewTopic("gtfs.trips", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsAgency() {
        return new NewTopic("gtfs.agency", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsFeed() {
        return new NewTopic("gtfs.feedinfo", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsShapes() {
        return new NewTopic("gtfs.shapes", 1, (short) 1);
    }

    @Bean
    public NewTopic gtfsTransfers() {
        return new NewTopic("gtfs.transfers", 1, (short) 1);
    }
}
