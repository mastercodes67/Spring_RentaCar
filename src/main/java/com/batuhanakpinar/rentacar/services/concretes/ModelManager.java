package com.batuhanakpinar.rentacar.services.concretes;

import com.batuhanakpinar.rentacar.core.utilites.exceptions.BusinessExceptions;
import com.batuhanakpinar.rentacar.core.utilites.mappers.ModelMapperService;
import com.batuhanakpinar.rentacar.entities.Model;
import com.batuhanakpinar.rentacar.repositories.ModelRepository;
import com.batuhanakpinar.rentacar.services.abstracts.ModelService;
import com.batuhanakpinar.rentacar.services.dtos.request.CreateModelRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        // Veritabanından ham veriyi çek
        List<Model> models = modelRepository.findAll();

        // 2. MAPPER İLE DÖNÜŞTÜR (Stream API)
        List<GetAllModelResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forRespose()
                        .map(model, GetAllModelResponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        // Kural kontrolü
        if (this.modelRepository.existsByName(createModelRequest.getName())) {
            throw new BusinessExceptions("Model ismi zaten mevcut!");
        }

        // 3. MAPPER İLE DÖNÜŞTÜR (Sihirli Satır)
        // Bu satır; createModelRequest içindeki 'name' ve 'brandId'yi alır,
        // Model nesnesinin içine yerleştirir.
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);

        // Kaydet
        this.modelRepository.save(model);
    }
}
