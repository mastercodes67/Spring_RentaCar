package com.batuhanakpinar.rentacar.repositories;

import com.batuhanakpinar.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsById(Integer id);
    boolean existsByName(String name);
}
