package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.Model.TypePrestation;
import com.appliance.AFAPP.dto.PovDto;
import com.appliance.AFAPP.dto.TypeDto;
import com.appliance.AFAPP.dto.TypePrestationDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TypePrestationMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;


    public TypePrestation typepdtotypep (TypePrestationDto typePrestationDto){
        TypePrestation typePrestation =dozerBeanMapper.map(typePrestationDto,TypePrestation.class);
        return typePrestation;
    }
    public TypePrestationDto typeptotypepdto (TypePrestation typePrestation){
        TypePrestationDto typePrestationDto =dozerBeanMapper.map(typePrestation,TypePrestationDto.class);
        return typePrestationDto;
    }

    public List<TypePrestation> listtypeprestationdtotypeprestation (List<TypePrestationDto> typePrestationDtos){
        List<TypePrestation>listtypeprestationdto =new ArrayList<>();
        typePrestationDtos.forEach(typeprestation->listtypeprestationdto.add( typepdtotypep(typeprestation)));
        return listtypeprestationdto;
    }

    public List<TypePrestationDto> listtypeprestationtypeprestationdto (List<TypePrestation> typePrestation){
        List<TypePrestationDto>listtypeprestation =new ArrayList<>();
        typePrestation.forEach(typeprestationdto->listtypeprestation.add( typeptotypepdto(typeprestationdto)));
        return listtypeprestation;
    }



}
