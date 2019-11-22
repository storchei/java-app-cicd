package org.esteban.demoapp.service;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("slowshutdown")
@Service
public class SlowShutdownService implements ShutdownService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlowShutdownService.class);

    @PreDestroy
    @Override
    public void cleanupApp() {
        LOGGER.info("Shutting down slowly..");
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            LOGGER.error("Error while waiting during slow shutdown.", e);
        }

        LOGGER.info("Shutdown graceful done in 15 secs!");
    }
}
