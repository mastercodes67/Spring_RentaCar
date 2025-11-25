package com.batuhanakpinar.rentacar.services.concretes;

import com.batuhanakpinar.rentacar.services.abstracts.ModelService;
import com.batuhanakpinar.rentacar.services.dtos.request.CreateModelRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    @Override
    public List<GetAllModelResponse> getAll() {
        return List.of();
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {

    }
}
