package dev.glabay.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @author Glabay | Glabay-Studios
 * @project shared
 * @social Discord: Glabay
 * @since 2025-10-31
 */
public abstract class MidnightEventProducer<T> {
    private final Producer<String, String> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String topic;

    public MidnightEventProducer(String kafkaHost, String topic) {
        var props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    public void sendProducedEvent(Event<T> event) {
        try {
            var json = objectMapper.writeValueAsString(event);

            var record = new ProducerRecord<>(topic, event.getEventId(), json);

            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    onError(event, exception);
                } else {
                    onSuccess(event, metadata);
                }
            });
        } catch (Exception e) {
            onError(event, e);
        }
    }


    protected void onSuccess(Event<T> event, RecordMetadata metadata) {
        System.out.printf("✅ Sent event %s to topic %s (offset=%d)%n",
            event.getEventType(), metadata.topic(), metadata.offset());
    }

    protected void onError(Event<T> event, Exception e) {
        System.err.printf("❌ Failed to send event %s: %s%n",
            event.getEventType(), e.getMessage());
    }

    public void close() {
        producer.close();
    }
}
