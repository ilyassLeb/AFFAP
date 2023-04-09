package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.dto.PovDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPovService {

    PovDto createPov(PovDto pov);
    List<PovDto> findAll();
    PovDto updatePov(PovDto pov ,Long id);
    String deletepov(Long id);
}
