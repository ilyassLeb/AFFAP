package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Type;
import com.appliance.AFAPP.Model.TypePrestation;
import com.appliance.AFAPP.dto.TypePrestationDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITypePrestationService {

    TypePrestationDto createTypePrestation(TypePrestationDto typePrestationDto);
    List<TypePrestationDto> findAll();
    TypePrestationDto updateTypePrestation(TypePrestationDto typePrestationDto,Long id);
    String deleteTypePrestation(Long id);
}
