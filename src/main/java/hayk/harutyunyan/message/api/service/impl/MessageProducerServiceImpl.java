package hayk.harutyunyan.message.api.service.impl;

import hayk.harutyunyan.message.api.constant.KafkaConstant;
import hayk.harutyunyan.message.api.service.MessageProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageProducerServiceImpl implements MessageProducerService
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)
    {
        log.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(KafkaConstant.TOPIC_NAME, message, message);
    }
}
