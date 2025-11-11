package dev.glabay.dtos;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-technician
 * @social Discord: Glabay
 * @since 2025-11-05
 */
public record ScheduleDto(
    String id,
    String employeeId,
    LocalDate weekStartDate,
    List<Shift> shifts
) {}
