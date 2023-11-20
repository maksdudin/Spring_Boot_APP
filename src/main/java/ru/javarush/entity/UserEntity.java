package ru.javarush.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users", schema = "first_project")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="age")
    private int age;

    @Column(name ="name")
    private String name;

    private String productName;

    @CreationTimestamp()
    @Column(name = "created_date")
    private LocalDateTime createdAt;

    @UpdateTimestamp()
    @Column(name = "updated_date")
    private LocalDateTime updatedAt;

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public UserEntity setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserEntity setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
