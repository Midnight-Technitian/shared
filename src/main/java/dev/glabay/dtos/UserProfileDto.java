package dev.glabay.dtos;

import dev.glabay.models.roles.Role;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
public record UserProfileDto(
    String email,
    String firstName,
    String lastName,
    String contactNumber,
    Set<Role> roles,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}