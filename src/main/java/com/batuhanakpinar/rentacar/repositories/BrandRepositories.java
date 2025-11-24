package com.batuhanakpinar.rentacar.repositories;

import com.batuhanakpinar.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// JpaRepository<HangiEntity, ID'siHangiTürden>
public interface BrandRepositories extends JpaRepository<Brand, Integer> {
    // Burası şimdilik boş.
    // Çünkü JpaRepository'den miras aldığımız için;
    // save(), findAll(), findById(), delete() gibi metotlar
    // zaten cebimizde hazır!
    boolean existsByName(String name);
}
