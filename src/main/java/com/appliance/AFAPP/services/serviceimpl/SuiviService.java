package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.Model.Suivi;
import com.appliance.AFAPP.dto.SuiviDto;
import com.appliance.AFAPP.mapping.SuiviMapper;
import com.appliance.AFAPP.repo.SuiviRepo;
import com.appliance.AFAPP.services.ISuiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuiviService implements ISuiviService {
    @Autowired
    SuiviRepo suiviRepo;
    @Autowired
    SuiviMapper suiviMapper;



    @Override
    public SuiviDto createSuivi(SuiviDto suivi) {
        return suiviMapper.suivitosuividto(suiviRepo.save(suiviMapper.suividtosuivi(suivi))) ;
    }

    @Override
    public List<SuiviDto> findAll() {
        return  suiviMapper.listsuivitolistsuividto(suiviRepo.findAll());
    }

    @Override
    public SuiviDto updateSuivi(SuiviDto suividto, Long id) {
        return suiviRepo.findById(id)
                .map(p->{
                    p.setMantant(suividto.getMantant());
                    p.setOffre_commerciale(suividto.getOffre_commerciale());
                    return  suiviMapper.suivitosuividto( suiviRepo.save(p));

                }).orElseThrow(()->new RuntimeException("la suivi Non trouvé "));
    }

    //update

    @Override
    public String deleteSuivi(Long id) {
        suiviRepo.deleteById(id);
        return "deleted";
    }
}
