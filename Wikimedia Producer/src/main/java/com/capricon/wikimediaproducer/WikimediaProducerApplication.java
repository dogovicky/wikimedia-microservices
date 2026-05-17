package com.capricon.wikimediaproducer;

import com.capricon.wikimediaproducer.producers.WikimediaChangesProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class WikimediaProducerApplication implements CommandLineRunner {

    private final WikimediaChangesProducer changesProducer;

    public static void main(String[] args) {
        SpringApplication.run(WikimediaProducerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("================ Calling Message ================");
        changesProducer.sendMessage();
    }
}
