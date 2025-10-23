package dev.glabay.models.request;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-23
 */
public record ServiceRequest(
    String customerEmail,
    String serviceId,
    String deviceId,
    String deviceName,
    String serviceDescription
) {}
