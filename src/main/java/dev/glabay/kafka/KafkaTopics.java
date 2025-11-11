package dev.glabay.kafka;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-01
 */
public enum KafkaTopics {
    USER_REGISTRATION("user-registered"),
    CUSTOMER_CREATION("customer-created"),
    SERVICE_TICKET_CREATION("service-ticket-creation"),
    CUSTOMER_DEVICE_REGISTRATION("customer-device-registration"),

    /// Email
    EMAIL_SEND_REQUEST("email-send-request"),
    EMAIL_SENT_ANALYTIC("email-sent-analytic"),

    /// Analytic Services below
    SERVICE_TICKET_CREATED("service-ticket-created"),
    SERVICE_TICKET_CLAIMED("service-ticket-claimed"),
    SERVICE_TICKET_UPDATED("service-ticket-update"),
    SERVICE_TICKET_CLOSED("service-ticket-closed"),

    ///  Customer Creation
    CUSTOMER_CREATED_ANALYTIC("customer-created-analytic"),

    /// Scheduling
    TECHNICIAN_CLOCK_IN("technician-clock-in"),
    TECHNICIAN_CLOCK_OUT("technician-clock-out"),
    ;
    private final String topicName;

    KafkaTopics(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
