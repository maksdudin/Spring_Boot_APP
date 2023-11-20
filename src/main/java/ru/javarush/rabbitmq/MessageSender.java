package ru.javarush.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.javarush.dto.UserDto;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue("myQueue", false);
    }

    public void send( UserDto userDto) {
        rabbitTemplate.convertAndSend("myQueue", userDto);
        System.out.println(" [x] Sent '" + userDto + "'");
    }
}

// TODO pls run command for RabbitMQ
// docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
