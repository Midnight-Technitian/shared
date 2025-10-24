package dev.glabay.dtos;

import dev.glabay.models.ServiceNote;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-24
 */
public record ServiceTicketDto(
    String ticketId,
    String status,
    String title,
    String description,
    String customerId,
    String customerDeviceId,
    String employeeId,
    String serviceId,
    List<ServiceNote> notes,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}