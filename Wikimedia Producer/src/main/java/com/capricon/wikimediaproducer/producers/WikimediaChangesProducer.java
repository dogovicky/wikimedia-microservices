package com.capricon.wikimediaproducer.producers;

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws StreamException, InterruptedException {

        String topic = "wikimedia_recentchange";

        // Add Headers
        Headers headers = new Headers.Builder()
                .add("User-Agent", "Wikimedia/1.0 (dogovicky05@gmail.com)")
                .build();

        // To read real time stream data from wikimedia, we use event source
        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(
                eventHandler, new EventSource.Builder(ConnectStrategy.http(URI.create(url))
                .headers(headers))
        ).build();

        eventSource.start();

       // TimeUnit.MINUTES.sleep(10);

    }

}
