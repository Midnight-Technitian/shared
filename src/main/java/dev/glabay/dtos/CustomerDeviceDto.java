package dev.glabay.dtos;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record CustomerDeviceDto(
    Long deviceId,
    Long customerId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String deviceName,
    String deviceType
) {}