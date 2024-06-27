package com.store.cursoapi2.message;

import com.store.cursoapi2.dto.CarPostDTO;
import com.store.cursoapi2.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerMessage {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerMessage.class);
    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car_post_topic", groupId = "store-post-group")
    public void receiveMessage(CarPostDTO carPostDTO) {

        LOGGER.info("Recived Car Post information: " + carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }



}
