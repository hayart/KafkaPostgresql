package hayk.harutyunyan.message.api.service.impl;

import hayk.harutyunyan.message.api.constant.KafkaConstant;
import hayk.harutyunyan.message.api.model.MessageEntity;
import hayk.harutyunyan.message.api.repository.MessageRepository;
import hayk.harutyunyan.message.api.service.MessageConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumerServiceImpl implements MessageConsumerService
{

    private final MessageRepository messageRepository;

    public MessageConsumerServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = KafkaConstant.TOPIC_NAME,
            groupId = KafkaConstant.GROUP_ID)
    public void consume(String message)
    {
        MessageEntity entity = new MessageEntity();
        entity.setData(message);
        messageRepository.save(entity);
        log.info(String.format("Message consume -> %s", message));
    }
}
