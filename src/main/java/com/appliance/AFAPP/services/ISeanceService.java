package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.dto.SeanceDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISeanceService {

    SeanceDto createSeance(SeanceDto seanceDto);
    List<SeanceDto> findAll();
    SeanceDto updateSeance(SeanceDto seanceDto ,Long id);
    String deleteSeance(Long id);
}
