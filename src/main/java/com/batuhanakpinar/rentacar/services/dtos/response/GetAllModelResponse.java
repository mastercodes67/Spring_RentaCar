package com.batuhanakpinar.rentacar.services.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {
    private int id;
    private String name;
    private String brandName;// <-- ID değil, İsim döndüreceğiz. Havalı kısım burası.

}
