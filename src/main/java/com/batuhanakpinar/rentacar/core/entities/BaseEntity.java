package com.batuhanakpinar.rentacar.core.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@MappedSuperclass // 1. JPA'ya diyoruz ki: Bu bir tablo değil, diğer tabloların atasıdır.
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "createdDate", updatable = false) // İlk oluştuğunda yazılır, güncellenmez.
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updatedDate") // Her güncellemede tarih değişir.
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
