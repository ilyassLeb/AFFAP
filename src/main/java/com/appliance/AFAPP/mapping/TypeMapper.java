package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Type;
import com.appliance.AFAPP.dto.TypeDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TypeMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    public TypeDto typetotypedto(Type type){

        TypeDto typeDto = dozerBeanMapper.map(type, TypeDto.class);
        return typeDto;
    }

    //Dto To Entity
    public Type typedtototype(TypeDto typeDto){
        Type type= dozerBeanMapper.map(typeDto, Type.class);

        return type;
    }

    //List Dto To List Entity
    public List<Type> listtypedtotoentitytype (List<TypeDto> typedto) {

        List<Type> LstTypeDto = new ArrayList<>();
        typedto.forEach(TypeDto -> LstTypeDto.add(typedtototype(TypeDto)));
        return LstTypeDto;

    }

    //List Entity To List DTO
    public List<TypeDto> ListEntitytypeToEntitytypedto(List<Type> type) {

        List<TypeDto> LstType = new ArrayList<>();
       type.forEach(Type -> LstType.add(typetotypedto(Type)));
        return LstType;
    }


}
