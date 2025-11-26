package com.batuhanakpinar.rentacar.services.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    @NotBlank // Stringler için (Boşluk olamaz)
    @Size(min = 3, max = 20)
    private String name;

    @NotNull // Sayılar için (Boş olamaz)
    private int brandId;
    // DİKKAT: Burada "brand" diye bir değişken YOK! Sadece brandId var.
}