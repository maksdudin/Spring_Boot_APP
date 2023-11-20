package ru.javarush.client;

import ru.javarush.client.dto.ProductFirstDto;
import ru.javarush.config.ClientConfiguration;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api-product", url = "${api.product}",
        configuration = ClientConfiguration.class)
public interface ProductClient {

    @GetMapping()
    List<ProductFirstDto> getProducts();

}
