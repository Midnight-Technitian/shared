package dev.glabay.dtos;

import dev.glabay.models.EmploymentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record EmployeeDto(
   String employeeId,
   String email,
   String firstName,
   String lastName,
   String contactNumber,
   String positionTitle,
   String profileImageUrl,
   String createdBy,
   String updatedBy,

   EmploymentStatus status,

   LocalDate employeeStartDate,
   LocalDate employeeEndDate,

   LocalDateTime lastLoginAt,
   LocalDateTime createdAt,
   LocalDateTime updatedAt
) {}