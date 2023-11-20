package ru.javarush.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javarush.dto.UserDto;
import ru.javarush.rabbitmq.MessageSender;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageSender messageSender;

    @PostMapping("/send")
    public String sendMessage(@RequestBody UserDto userDto) {
        messageSender.send(userDto);
        return "Message sent: " + userDto;
    }
}
