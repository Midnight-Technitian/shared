package dev.glabay.dtos;

import java.time.LocalDateTime;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record CustomerDto(
    String firstName,
    String lastName,
    String email,
    String contactNumber,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}