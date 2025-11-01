package dev.glabay.kafka;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-11-01
 */
public enum KafkaTopics {
    USER_REGISTRATION("user-registered"),
    CUSTOMER_CREATION("customer-created")
    ;
    private final String topicName;

    KafkaTopics(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
