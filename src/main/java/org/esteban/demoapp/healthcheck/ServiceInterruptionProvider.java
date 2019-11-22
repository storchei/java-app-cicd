package org.esteban.demoapp.healthcheck;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ServiceInterruptionProvider {

    Optional<LocalDateTime> getLastServiceInterruption();
}
