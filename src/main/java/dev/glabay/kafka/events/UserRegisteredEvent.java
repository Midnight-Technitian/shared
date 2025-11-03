package dev.glabay.kafka.events;

import dev.glabay.dtos.UserProfileDto;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-01
 */
public record UserRegisteredEvent(UserProfileDto userDto, String ipAddress) {}
