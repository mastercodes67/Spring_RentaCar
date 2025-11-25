package com.batuhanakpinar.rentacar.entities;

import com.batuhanakpinar.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Table(name ="models")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Model extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    // --İlişlilere Başlıyoruz--
    @ManyToOne // Bir model bir markaya aittir
    @JoinColumn(name ="brand_id")
    private Brand brand; //Nesne olarak oluşturuyoruz , INT değil !!
}
