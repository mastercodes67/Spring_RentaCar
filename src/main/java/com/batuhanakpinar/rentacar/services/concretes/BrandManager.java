package com.batuhanakpinar.rentacar.services.concretes;

import com.batuhanakpinar.rentacar.core.utilites.exceptions.BusinessExceptions;
import com.batuhanakpinar.rentacar.entities.Brand;
import com.batuhanakpinar.rentacar.repositories.BrandRepositories;
import com.batuhanakpinar.rentacar.services.abstracts.BrandService;
import com.batuhanakpinar.rentacar.services.dtos.request.CreateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.request.UpdateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service        // 1. Spring, bu sınıfı hafızana al.
@AllArgsConstructor // 2. Constructor oluşturup Repository'yi enjekte et.
public class BrandManager implements BrandService {
    private BrandRepositories brandRepositories;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        // 1. DEPODAN ÇEK: Veritabanındaki her şeyi getir.
        // brands listesi = [Brand(id:1, name:"BMW"), Brand(id:2, name:"Audi")]
        List<Brand> brands = brandRepositories.findAll();
        // 2. BOŞ KUTU HAZIRLA: Sonuçları koyacağımız boş bir liste.
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<>();
        // 3. TEK TEK DOLAŞ VE AKTAR
        for(Brand brand : brands){  //brands listesindeki her bir 'brand' için dönecek
            // 3a. Yeni, boş bir vitrin kartı oluştur (Response nesnesi)
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            // 3b. Depodaki malın özelliklerini, vitrin kartına yaz.
            responseItem.setName(brand.getName());      // İsmi kopyala
            responseItem.setId(brand.getId());  // ID'yi kopyala
            // 3c. Hazırladığın kartı, ana kutuya (brandsResponse) at.
            brandsResponse.add(responseItem);
        }
        // 4. Hazır listeyi döndür
        return brandsResponse;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        // 1. Manuel Mapping: Request'i Entity'ye çeviriyoruz.
        if (this.brandRepositories.existsByName(createBrandRequest.getName())) {
            throw new BusinessExceptions("This name already exists!");
        }
        Brand brand = new Brand();
        // ID set etmiyoruz, çünkü veritabanı otomatik veriyor.
        brand.setName(createBrandRequest.getName());
        // 2. Veritabanına yolcu ediyoruz.
        this.brandRepositories.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = new Brand();
        brand.setName(updateBrandRequest.getName());
        brand.setId(updateBrandRequest.getId());
        this.brandRepositories.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepositories.findById(id).ifPresent(this.brandRepositories::delete);
    }


}
