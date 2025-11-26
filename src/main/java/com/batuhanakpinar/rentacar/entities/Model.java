package com.batuhanakpinar.rentacar.entities;

import com.batuhanakpinar.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "models")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand; // İsmi "brand" olmalı.
}