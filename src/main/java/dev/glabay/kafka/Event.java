package dev.glabay.kafka;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

/**
 * @author Glabay | Glabay-Studios
 * @project shared
 * @social Discord: Glabay
 * @since 2025-10-31
 */
@Getter
public class Event<T> {
    protected final String eventType;
    protected final Instant timestamp;
    protected final String eventId;
    protected T data;

    public Event(String eventType, T data) {
        this.eventType = eventType;
        this.timestamp = Instant.now();
        this.eventId = UUID.randomUUID().toString();
        this.data = data;
    }
}
