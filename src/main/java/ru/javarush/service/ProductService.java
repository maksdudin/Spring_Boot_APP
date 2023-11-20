package ru.javarush.service;

import ru.javarush.client.ProductClient;
import ru.javarush.client.dto.ProductFirstDto;
import ru.javarush.exception.ResourceNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public List<ProductFirstDto> getProducts() {
        if (1 == 1) {
            throw new ResourceNotFoundException("It is my test exception");
        }
        return productClient.getProducts();
    }

}
