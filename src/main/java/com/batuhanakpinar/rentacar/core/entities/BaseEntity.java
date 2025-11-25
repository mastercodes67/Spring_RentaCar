package com.batuhanakpinar.rentacar.core.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass // 1. JPA'ya diyoruz ki: Bu bir tablo değil, diğer tabloların atasıdır.
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

}
