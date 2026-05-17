package com.capricon.wikimediaconsumer.consumer;

import com.capricon.wikimediaconsumer.model.WikimediaData;
import com.capricon.wikimediaconsumer.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaKafkaConsumer {

    private final WikimediaDataRepository dataRepository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "mediaGroup")
    public void consumeMessages(String eventMessage) {
        log.info("=============== Message Received: {} ===============", eventMessage);

        // Save the stream data to  db
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);

        dataRepository.save(data);

    }

}
