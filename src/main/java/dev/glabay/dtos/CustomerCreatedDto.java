package dev.glabay.dtos;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-technician
 * @social Discord: Glabay
 * @since 2025-11-11
 */
public record CustomerCreatedDto(
    String customerEmail,
    String firstName,
    String lastName,
    String contactNumber,
    String registeredBy
) {}
