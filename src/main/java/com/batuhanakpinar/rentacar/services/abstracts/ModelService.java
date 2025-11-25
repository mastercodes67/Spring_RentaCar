package com.batuhanakpinar.rentacar.services.abstracts;

import com.batuhanakpinar.rentacar.services.dtos.request.CreateModelRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
