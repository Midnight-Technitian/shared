package dev.glabay.kafka.events;

import dev.glabay.models.device.RegisteringDevice;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-02
 */
public record CustomerDeviceRegistrationEvent(RegisteringDevice registeringDevice) {}
