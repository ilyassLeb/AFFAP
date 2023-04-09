package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Type;
import com.appliance.AFAPP.dto.TypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITypeService {

    TypeDto createType(TypeDto typedto);
    List<TypeDto> findAll();
    TypeDto updateType(TypeDto typeDto ,Long id);
    String deleteType(Long id);
  //  List <Type> findType(Long id);
}
