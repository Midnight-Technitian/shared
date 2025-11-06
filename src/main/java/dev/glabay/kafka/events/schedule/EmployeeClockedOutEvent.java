package dev.glabay.kafka.events.schedule;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-technician
 * @social Discord: Glabay
 * @since 2025-11-05
 */
public record EmployeeClockedOutEvent(
    String employeeId,
    LocalDateTime clockOutTime,
    Duration totalWorked
) {}
