package dev.glabay.kafka.events.customer;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-01
 */
public record CustomerRegisteredEvent(
    String customerEmail,
    String firstName,
    String lastName,
    String contactNumber,
    String registeredBy
) {}
