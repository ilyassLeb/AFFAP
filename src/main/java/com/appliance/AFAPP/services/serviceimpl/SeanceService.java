package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.dto.SeanceDto;
import com.appliance.AFAPP.mapping.SeanceMapper;
import com.appliance.AFAPP.repo.SeanceRepo;
import com.appliance.AFAPP.services.ISeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeanceService implements ISeanceService {
    @Autowired
     SeanceRepo seanceRepo;
    @Autowired
    SeanceMapper seanceMapper;




    @Override
    public List<SeanceDto> findAll() {
        return  seanceMapper.listeseancetolisteseance(seanceRepo.findAll());
    }

    @Override
    public SeanceDto createSeance(SeanceDto seance) {
        return    seanceMapper.seancetoseancedto(seanceRepo.save(seanceMapper.seancedtotoseance(seance)));
    }



    @Override
    public SeanceDto updateSeance(SeanceDto seance, Long id) {
        return seanceRepo.findById(id)
                .map(p->{
                    p.setDate_Seance(seance.getDate_Seance());
                    p.setParticipant(seance.getParticipant());
                    p.setResume(seance.getResume());
                  //  p.setPov(seance.getPov());
                    return seanceMapper.seancetoseancedto(seanceRepo.save(p));

                }).orElseThrow(()->new RuntimeException("pas de seance"));
    }

    @Override
    public String deleteSeance(Long id) {
        seanceRepo.deleteById(id);
        return "supprimé";
    }
}
