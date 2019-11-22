package org.esteban.demoapp.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("slowboot")
@Service
public class SlowBootstrapService implements BootstrapService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlowBootstrapService.class);

    @PostConstruct
    @Override
    public void initApp() {
        LOGGER.info("Bootstrapping slowly..");
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            LOGGER.error("Error while waiting during bootstrap", e);
        }

        LOGGER.info("Bootstrapped in 10 secs!");
    }
}
