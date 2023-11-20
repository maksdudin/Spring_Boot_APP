package ru.javarush.config;

import ru.javarush.client.ProductClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ProductClient.class})
public class ClientConfiguration {
}
