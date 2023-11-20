package ru.javarush.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
public class UserDto implements Serializable {

    private int age;
    private String name;

}
