package com.batuhanakpinar.rentacar.core.utilites.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 1. Tüm Controller'ları dinle (AOP)
public class GlobalExceptionHandler {


    // Bu metot, sadece BusinessException fırlatıldığında çalışır.
    @ExceptionHandler(BusinessExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 2. Hata kodu olarak 400 dön (500 değil!)
    public ProblemDetails handleBusinessException(BusinessExceptions businessException) {

        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        // Hatanın mesajını (Manager'dan gelen mesajı) kutuya koy
        problemDetails.setMessage(businessException.getMessage());

        return problemDetails;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException exception) {

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION_EXCEPTION");

        Map<String, String> validationErrors = new HashMap<>();

        // Tüm hataları gez (name boş, fiyat negatif vs.)
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        validationProblemDetails.setValidationErrors(validationErrors);

        return validationProblemDetails;
    }
}