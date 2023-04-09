package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.dto.ApplianceDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IApplianceService {
    ApplianceDto createAppliance(ApplianceDto appliance);
    List<ApplianceDto> findAll();
    ApplianceDto updateAppliance(ApplianceDto appliance,Long id);
    void deleteAppliance(Long id);


}
