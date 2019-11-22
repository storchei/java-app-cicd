package org.esteban.demoapp.healthcheck;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component
public class AdHocInterruptionProvider implements ServiceInterruptionProvider {

    private static final String CACHE_KEY_INTERRUPTIONS = "interruption";

    private final Cache<String, LocalDateTime> interruptionsCache;

    public AdHocInterruptionProvider(@Value("${healthCheckInterruptionDurationSeconds}") Integer healthCheckInterruptionExpiration) {
        interruptionsCache = CacheBuilder.newBuilder()
                                         .maximumSize(1)
                                         .expireAfterWrite(healthCheckInterruptionExpiration, TimeUnit.SECONDS)
                                         .build();
    }

    @Override
    public Optional<LocalDateTime> getLastServiceInterruption() {
        return Optional.ofNullable(interruptionsCache.getIfPresent(CACHE_KEY_INTERRUPTIONS));
    }

    public void createInterruption() {
        interruptionsCache.put(CACHE_KEY_INTERRUPTIONS, LocalDateTime.now());
    }
}
