package ru.javarush.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.javarush.dto.UserDto;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "myQueue")
    public void receive(UserDto userDto) {
        System.out.println(" [x] Received '" + userDto + "'");
    }
}
