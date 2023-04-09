package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.dto.PovDto;
import com.appliance.AFAPP.mapping.PovMapper;
import com.appliance.AFAPP.repo.PovRepo;
import com.appliance.AFAPP.services.IPovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PovService implements IPovService {

    @Autowired
    PovRepo povRepo;

    @Autowired
    PovMapper povMapper;

    @Override
    public PovDto createPov(PovDto pov) {
        return  povMapper.povtopovdto(povRepo.save(povMapper.povdtotopov(pov))) ;
    }

    @Override
    public List<PovDto> findAll() {
        return povMapper.listpovtolistpovdto(povRepo.findAll()) ;
    }

    @Override
    public PovDto updatePov(PovDto pov, Long id) {
        boolean existe =povRepo.existsById(id);
        if(existe){
            povMapper.povtopovdto(povRepo.save(povMapper.povdtotopov(pov)));
        }

        return pov;
    }


    @Override
    public String deletepov(Long id) {
         povRepo.deleteById(id);
        return "supprimé";
    }
}
