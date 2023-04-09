package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.dto.SeanceDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SeanceMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    PovMapper povMapper;


    public SeanceDto seancetoseancedto(Seance seance){
        SeanceDto seanceDto=dozerBeanMapper.map(seance,SeanceDto.class);

        if(seanceDto.getPovDto()!=null){
            seanceDto.setPovDto(povMapper.povtopovdto(seance.getPov()));
        }
        return seanceDto;
    }

    public Seance seancedtotoseance(SeanceDto seanceDto){
        Seance seance=dozerBeanMapper.map(seanceDto,Seance.class);
        if(seance.getPov()!=null){

            seance.setPov(povMapper.povdtotopov(seanceDto.getPovDto()));

        }

        return seance;
    }

    public List<Seance> listseancedtolistseance(List<SeanceDto> seanceDtos){
        List<Seance>listseancedto =new ArrayList<>();
        seanceDtos.forEach(seancedto->listseancedto.add(seancedtotoseance(seancedto)));
        return listseancedto;
    }

    public List<SeanceDto> listeseancetolisteseance(List<Seance>seances){
        List<SeanceDto> listeseance=new ArrayList<>();
        seances.forEach(seance -> listeseance.add(seancetoseancedto(seance)));
        return listeseance;
    }


}
