package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.Model.Suivi;
import com.appliance.AFAPP.dto.SuiviDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISuiviService {

    SuiviDto createSuivi(SuiviDto suiviDto);
    List<SuiviDto> findAll();
    SuiviDto updateSuivi(SuiviDto suiviDto ,Long id);
    String deleteSuivi(Long id);
}
