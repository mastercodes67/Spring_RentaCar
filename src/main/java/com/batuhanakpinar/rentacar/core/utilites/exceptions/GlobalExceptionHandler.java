package com.batuhanakpinar.rentacar.core.utilites.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}