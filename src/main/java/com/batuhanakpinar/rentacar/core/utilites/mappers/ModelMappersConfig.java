package com.batuhanakpinar.rentacar.core.utilites.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //// 1. Spring'e diyoruz ki: Bu bir ayar sınıfıdır.
public class ModelMappersConfig {
    @Bean //2. Spring'e diyoruz ki: Bu metot bir nesne üretir, onu al IoC kutuna koy.
    public ModelMapper getModelMapper() {
       ModelMapper modelMapper = new ModelMapper();
       //// 3. Strateji Ayarı: LOOSE (Gevşek)
       //// Neden? Çünkü veritabanında "brand" diye bir nesne var ama DTO'da "brandId" var.
       //// "Gevşek" mod, kelimeleri benzeterek eşleştirme yapar (brandId -> brand'in id'si).

       modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
       return modelMapper;
    }
}
