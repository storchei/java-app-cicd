package org.esteban.demoapp.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping(path = "/v1", produces = APPLICATION_JSON_VALUE)
public class FooIrController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FooIrController.class);

    @Value("${application.version}")
    private String version;

    private final Counter requestCounter;

    public FooIrController(MeterRegistry meterRegistry) {
        requestCounter = meterRegistry.counter("search.requests");
    }


    @GetMapping(path = "/search")
    ResponseDto getVersion() {
        requestCounter.increment();

        LOGGER.info("GET Request to /v1/search, appVersion: {}", version);
        return new ResponseDto(version);
    }
}
