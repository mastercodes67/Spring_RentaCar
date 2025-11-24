package com.batuhanakpinar.rentacar.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Kullanıcıdan marka eklerken sadece isim istiyoruz)
public class CreateBrandRequest {
    private String name;
}
