package hayk.harutyunyan.message.api.controller;

import hayk.harutyunyan.message.api.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageProducerController
{
    private final MessageProducerService producerService;

    @Autowired
    public MessageProducerController(MessageProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToTopic(@RequestParam("data") String message)
    {
        this.producerService.sendMessage(message);
    }
}
