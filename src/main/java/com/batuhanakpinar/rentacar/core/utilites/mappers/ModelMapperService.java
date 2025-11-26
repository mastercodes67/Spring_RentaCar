package com.batuhanakpinar.rentacar.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    //// Bize Response için ayrı, Request için ayrı mapper stratejisi verecek.
    ModelMapper forRespose();
    ModelMapper forRequest();
}
