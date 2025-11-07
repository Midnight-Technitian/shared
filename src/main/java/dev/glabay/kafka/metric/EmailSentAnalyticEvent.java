package dev.glabay.kafka.metric;

import java.time.LocalDateTime;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-11-02
 */
public record EmailSentAnalyticEvent(
    String emailId,
    String recipient,
    String templateName,
    String triggeredBy,
    LocalDateTime sentAt,
    EmailStatus status,
    String serviceOrigin
) {}
