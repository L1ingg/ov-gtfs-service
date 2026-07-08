package com.ling.ovgtfsservice;

import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class GtfsHandler {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;
    private final List<GtfsProcessor> processors;

    public GtfsHandler(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper, List<GtfsProcessor> processors) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
        this.processors = processors;
    }

    @EventListener
    public void onGtfsUpdate(OnGtfsUpdate event) {
        for (GtfsProcessor processor : processors) {
            kafkaTemplate.send(
                    processor.topic(),
                    mapper.writeValueAsString(
                            processor.parse(event.record())
                    )
            );
        }

    }
}
