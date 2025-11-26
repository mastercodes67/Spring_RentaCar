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
    @NotBlank
    private String brand;
    @Size(min = 3, max = 20)
    private String model;
    private int brandId; //Kullanıcıdan Id istiyoruz

    public String getName() {
        return this.getName();
    }
    public int getBrandId() {
        return this.getBrandId();
    }
}
