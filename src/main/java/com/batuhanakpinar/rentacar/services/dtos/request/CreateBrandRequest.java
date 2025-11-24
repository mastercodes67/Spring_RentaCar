package com.batuhanakpinar.rentacar.services.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Kullanıcıdan marka eklerken sadece isim istiyoruz)
public class CreateBrandRequest {
    @Size
    @NotBlank
    private String name;

}
