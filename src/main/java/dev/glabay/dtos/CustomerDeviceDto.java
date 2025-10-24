package dev.glabay.dtos;

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
    Date dropOffDate,
    String notes
) {}