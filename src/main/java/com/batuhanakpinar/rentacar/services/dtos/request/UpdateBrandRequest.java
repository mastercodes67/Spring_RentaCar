package com.batuhanakpinar.rentacar.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private int id; // Hangi kayıt değişecek?
    private String name;    //Yeni ismi ne olacak

}
