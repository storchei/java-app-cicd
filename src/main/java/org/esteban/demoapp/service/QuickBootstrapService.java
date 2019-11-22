package org.esteban.demoapp.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!slowboot")
@Service
public class QuickBootstrapService implements BootstrapService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickBootstrapService.class);

    @PostConstruct
    @Override
    public void initApp() {
        LOGGER.info("Bootstrapping done quickly!");
    }
}
