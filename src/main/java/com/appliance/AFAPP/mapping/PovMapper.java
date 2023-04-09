package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.dto.PovDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class PovMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    ApplianceMapper applianceMapper;
    @Autowired
    ClientMapper clientMapper;

    public Pov povdtotopov (PovDto povDto){
        Pov pov =dozerBeanMapper.map(povDto,Pov.class);

        if(pov.getAppliance()!=null && pov.getClient()!=null){

           pov.setAppliance(applianceMapper.ApplianceDTOToAppliance(povDto.getDtoAppliance()));
            pov.setClient(clientMapper.clientdtoclient(povDto.getDtoClient()));
        }
        return pov;
    }
    public PovDto povtopovdto (Pov pov){
        PovDto povDto1=dozerBeanMapper.map(pov,PovDto.class);

        if(povDto1.getDtoClient()!=null&& povDto1.getDtoAppliance()!=null){
            povDto1.setDtoAppliance(applianceMapper.ApplianceToApplianceDTO(pov.getAppliance()));
            povDto1.setDtoClient(clientMapper.clientoclientdto(pov.getClient()));
        }


        return povDto1;
    }
public List<Pov> listpovdtotolistpov (List<PovDto> povDtos) {

        List<Pov> listpovdto=new ArrayList<>();
    povDtos.forEach(povdto->listpovdto.add(povdtotopov(povdto)));
    return  listpovdto;

}
public List<PovDto> listpovtolistpovdto (List<Pov> povs){
        List<PovDto> listpov =new ArrayList<>();
        povs.forEach(pov->listpov.add(povtopovdto(pov)));
          return listpov;
}


}
