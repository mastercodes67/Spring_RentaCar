package com.batuhanakpinar.rentacar.core.utilites.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    // Tüm hatalarda ortak olan özellikler
    private String message;
}
