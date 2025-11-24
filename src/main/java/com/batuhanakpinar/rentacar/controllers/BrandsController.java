package com.batuhanakpinar.rentacar.controllers;

import com.batuhanakpinar.rentacar.services.abstracts.BrandService;
import com.batuhanakpinar.rentacar.services.dtos.request.CreateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.request.UpdateBrandRequest;
import com.batuhanakpinar.rentacar.services.dtos.response.GetAllBrandsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//@RestController // 1. Ben bir API'yim
//@RequestMapping("/api/brands") // 2. Adresim budur
//@AllArgsConstructor // 3. Service'i bana getir

@RestController //"Bu sınıf bir API kontrolcüsüdür, JSON döner" der.
@RequestMapping("/api/brands")// "Tarayıcı adres çubuğuna localhost:8080/api/brands yazıldığında beni çağır" der. Web sitelerindeki adres mantığıdır.
@AllArgsConstructor //Yine bağımlılıkları (Service) otomatik almak için.
public class BrandsController {
    private BrandService brandService; //Şefimiz
    //listeleme işine geldik "GET"
    @GetMapping // LİSTELEME İŞLEMİ (GET) Tarayıcıdan direkt girince çalışır
    public List<GetAllBrandsResponse> getAll(){
        // Şefe söyle, listeyi getirsin
        return brandService.getAll();
    }
    // EKLEME İŞLEMİ (POST)
    @PostMapping //Veri gönderince çalışır
    // @RequestBody: "Gelen veriyi (JSON), CreateBrandRequest kutusuna doldur" demektir.
    // Şefe ilet, kaydetsin.
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping
    public void deleteAll(@PathVariable String id){
        this.brandService.delete(Integer.parseInt(id));
    }


}
