package dev.glabay.kafka.email;

import java.util.Map;

/**
 * Email send request contract for the Email service.
 *
 * @author Glabay | Glabay-Studios
 * @project backend
 * @since 2025-11-06
 */
public record EmailSendRequest(
    String emailId,
    String recipient,
    String subject,
    String templateName,
    Map<String, Object> templateData,
    String triggeredBy,
    String serviceOrigin,
    String correlationId,
    String replyTo
) {}
