package com.batuhanakpinar.rentacar.entities;

import com.batuhanakpinar.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands") //SQL'de oluşacak tablo adı
@Entity //Sen bir veritabanı varlığısın
@Getter //Okuma izinlerini (get) oluştur
@Setter //Yazma izinlerini (set) oluştu
@AllArgsConstructor // Dolu yapıcı metot
@NoArgsConstructor // Boş yapıcı metot (JPA için şart)

public class Brand extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
