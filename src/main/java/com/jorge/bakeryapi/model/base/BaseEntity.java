package com.jorge.bakeryapi.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_enabled", columnDefinition = "BOOLEAN default true")
    private Boolean isEnabled;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        isEnabled = true;
    }
    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
