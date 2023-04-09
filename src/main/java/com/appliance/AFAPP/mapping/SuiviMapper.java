package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Suivi;
import com.appliance.AFAPP.dto.SuiviDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SuiviMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
      PovMapper povMapper;
    @Autowired
         TypePrestationMapper typePrestationMapper;

public Suivi suividtosuivi (SuiviDto suiviDto){
    Suivi suivi =dozerBeanMapper.map(suiviDto,Suivi.class);

    if(suivi.getPov()!=null && suivi.getTypePrestation()!=null){

        suivi.setPov(povMapper.povdtotopov(suiviDto.getDtoPov()));
        suivi.setTypePrestation(typePrestationMapper.typepdtotypep(suiviDto.getDtoTypePrestation()));


    }
    return  suivi;
}
    public SuiviDto suivitosuividto (Suivi suivi){
        SuiviDto suiviDto =dozerBeanMapper.map(suivi,SuiviDto.class);
        if(suiviDto.getDtoPov()!=null && suiviDto.getDtoTypePrestation()!=null){

            suiviDto.setDtoPov(povMapper.povtopovdto(suivi.getPov()));
            suivi.setPov(povMapper.povdtotopov(suiviDto.getDtoPov()));


        }
        return  suiviDto;
    }

    public List<Suivi> listsuividtolistsuivi (List<SuiviDto> suiviDtos){
    List<Suivi> listsuividto =new ArrayList<>();
    suiviDtos.forEach(suividto->listsuividto.add(suividtosuivi (suividto)));
    return listsuividto;
    }

    public List<SuiviDto> listsuivitolistsuividto(List<Suivi> suivis){
    List<SuiviDto> listsuivi =new ArrayList<>();
    suivis.forEach(suivi -> listsuivi.add(suivitosuividto(suivi)));
    return listsuivi;

    }


}
