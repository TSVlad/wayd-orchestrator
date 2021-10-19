package ru.tsvlad.waydorchestrator.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.tsvlad.waydorchestrator.consumer.EventValidationMessage;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value("${wayd.kafka.address}")
    private String kafkaAddress;

    @Value("${wayd.kafka.producer.id}")
    private String kafkaProducerId;

    public Map<String, Object> producerConfigs(String producerPrefix) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, producerPrefix + kafkaProducerId);
        return props;
    }

    @Bean
    public ProducerFactory<Long, EventMessage> producerEventMessageFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("event-"));
    }

    @Bean
    public KafkaTemplate<Long, EventMessage> eventMessageKafkaTemplate() {
        KafkaTemplate<Long, EventMessage> template = new KafkaTemplate<>(producerEventMessageFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

    @Bean
    public ProducerFactory<Long, EventValidationMessage> producerEventValidationFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("event-validation-"));
    }

    @Bean
    public KafkaTemplate<Long, EventValidationMessage> eventValidationKafkaTemplate() {
        KafkaTemplate<Long, EventValidationMessage> template = new KafkaTemplate<>(producerEventValidationFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }
}
