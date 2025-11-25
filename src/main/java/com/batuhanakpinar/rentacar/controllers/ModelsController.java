package com.batuhanakpinar.rentacar.controllers;

import com.batuhanakpinar.rentacar.services.abstracts.ModelService;
import com.batuhanakpinar.rentacar.services.dtos.request.CreateModelRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}