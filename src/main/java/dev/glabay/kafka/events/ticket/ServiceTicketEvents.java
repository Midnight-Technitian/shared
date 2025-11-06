package dev.glabay.kafka.events.ticket;

import dev.glabay.dtos.ServiceTicketDto;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-02
 */
public class ServiceTicketEvents {
    public record ServiceTicketCreatedEvent(ServiceTicketDto requestDto) {}
    public record ServiceTicketClaimedEvent(ServiceTicketDto requestDto) {}
    public record ServiceTicketClosedEvent(ServiceTicketDto requestDto) {}
    public record ServiceTicketUpdatedEvent(ServiceTicketDto requestDto) {}
}
