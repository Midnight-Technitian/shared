package dev.glabay.kafka.events;

import dev.glabay.models.request.ServiceRequest;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-02
 */
public record ServiceTicketCreationEvent(ServiceRequest requestDto) {}
