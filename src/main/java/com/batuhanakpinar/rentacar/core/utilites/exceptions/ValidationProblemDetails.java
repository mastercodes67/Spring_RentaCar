package com.batuhanakpinar.rentacar.core.utilites.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    // Hangi alanda ne hata var? (Örn: "name": "boş olamaz")
    private Map<String, String> validationErrors;
}