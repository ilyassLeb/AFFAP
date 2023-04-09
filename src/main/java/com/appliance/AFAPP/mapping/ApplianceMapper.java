package com.appliance.AFAPP.mapping;


import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.dto.ApplianceDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ApplianceMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    TypeMapper typeMapper;


    public ApplianceDto ApplianceToApplianceDTO(Appliance appliance){
        ApplianceDto applianceDto = dozerBeanMapper.map(appliance, ApplianceDto.class);
//transformation de la  cle etrangere
        if(appliance.getType()!=null){
            applianceDto.setTypeDto(typeMapper.typetotypedto(appliance.getType()));
        }
        return applianceDto;
    }

    //Dto To Entity
    public Appliance ApplianceDTOToAppliance(ApplianceDto applianceDto){

        Appliance appliance = dozerBeanMapper.map(applianceDto, Appliance.class);


        if(applianceDto.getTypeDto()!=null){

               appliance.setType(typeMapper.typedtototype(applianceDto.getTypeDto()));
        }

        return appliance;
    }

    //List Dto To List Entity
    public List<Appliance> ListApplianceDTOToEntityAppliance (List<ApplianceDto> App) {

        List<Appliance> LstTypeDto = new ArrayList<>();
        App.forEach(ApplianceDTO -> LstTypeDto.add(ApplianceDTOToAppliance(ApplianceDTO)));

        return LstTypeDto;

    }

    //List Entity To List DTO
    public List<ApplianceDto> ListEntityApplianceToEntityAppliance(List<Appliance> App) {

        List<ApplianceDto> LstType = new ArrayList<>();
        App.forEach(Entitytype -> LstType.add(ApplianceToApplianceDTO(Entitytype)));
        return LstType;
    }

}
