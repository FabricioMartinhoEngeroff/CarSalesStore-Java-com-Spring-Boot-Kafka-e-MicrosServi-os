package com.store.carSalesStore.message;


import com.store.carSalesStore.dto.CarPostDTO;
import com.store.carSalesStore.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics =  "car-post-topic", groupId = "store-post-group")
    public void listening(CarPostDTO carPostDTO){

        LOG.info("Received Car Post information: {}", carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }
}