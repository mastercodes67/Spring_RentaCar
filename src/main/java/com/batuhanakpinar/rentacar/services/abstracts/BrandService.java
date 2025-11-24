package com.batuhanakpinar.rentacar.services.abstracts;

import com.batuhanakpinar.rentacar.services.dtos.request.CreateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.request.UpdateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllBrandsResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
