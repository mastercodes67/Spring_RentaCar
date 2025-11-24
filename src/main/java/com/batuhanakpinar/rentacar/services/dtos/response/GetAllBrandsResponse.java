package com.batuhanakpinar.rentacar.services.dtos.response;

//Kullanıcıya listelerken ID ve İsim dönüyoruz)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse{
    private int id;
    private String name;

}