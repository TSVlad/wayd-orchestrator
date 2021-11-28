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
import ru.tsvlad.waydorchestrator.messaging.ModerationMessage;
import ru.tsvlad.waydorchestrator.messaging.UserMessage;
import ru.tsvlad.waydorchestrator.messaging.ValidatorMessage;
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
    public ProducerFactory<Long, EventMessage> eventMessageFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("event-"));
    }

    @Bean
    public KafkaTemplate<Long, EventMessage> eventMessageKafkaTemplate() {
        KafkaTemplate<Long, EventMessage> template = new KafkaTemplate<>(eventMessageFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }


    @Bean
    public ProducerFactory<Long, ValidatorMessage> validatorMessageFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("event-validation-"));
    }

    @Bean
    public KafkaTemplate<Long, ValidatorMessage> validatorMessageKafkaTemplate() {
        KafkaTemplate<Long, ValidatorMessage> template = new KafkaTemplate<>(validatorMessageFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }


    @Bean
    public ProducerFactory<Long, UserMessage> userMessageFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("user-to-validator-"));
    }

    @Bean
    public KafkaTemplate<Long, UserMessage> userMessageKafkaTemplate() {
        KafkaTemplate<Long, UserMessage> template = new KafkaTemplate<>(userMessageFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

    @Bean
    public ProducerFactory<Long, ModerationMessage> moderationMessageFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs("moderation-to-validator-"));
    }

    @Bean
    public KafkaTemplate<Long, ModerationMessage> moderationMessageKafkaTemplate() {
        KafkaTemplate<Long, ModerationMessage> template = new KafkaTemplate<>(moderationMessageFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }
}
