package org.esteban.demoapp.healthcheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class IrHealthIndicator implements HealthIndicator {

    private static final String message_key = "demo";

    private static final DateTimeFormatter INTERRUPTION_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    private final ServiceInterruptionProvider interruptionProvider;

    public IrHealthIndicator(ServiceInterruptionProvider interruptionProvider) {
        this.interruptionProvider = interruptionProvider;
    }

    @Override
    public Health health() {
        Optional<LocalDateTime> lastInterruptionStartTime = interruptionProvider.getLastServiceInterruption();

        if (!lastInterruptionStartTime.isPresent()) {
            // service is healthy. No interruptions

            return Health.up().build();
        } else {
            // service is unhealthy. There is an interruption going on

            return Health.down()
                         .withDetail(message_key, "Service interrupted since: " + lastInterruptionStartTime.get().format(INTERRUPTION_TIME_FORMATTER))
                         .build();
        }
    }
}
