package com.appliance.AFAPP.services.serviceimpl;
import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.dto.ApplianceDto;
import com.appliance.AFAPP.mapping.ApplianceMapper;
import com.appliance.AFAPP.repo.ApplianceRepo;
import com.appliance.AFAPP.services.IApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplianceService implements IApplianceService {
@Autowired
 ApplianceRepo applianceRepo;
@Autowired
ApplianceMapper applianceMapper;

    @Override
    public ApplianceDto createAppliance(ApplianceDto appliance) {
        return  applianceMapper.ApplianceToApplianceDTO(applianceRepo.save(applianceMapper.ApplianceDTOToAppliance(appliance)));

    }

    @Override
    public List<ApplianceDto> findAll() {
        return applianceMapper.ListEntityApplianceToEntityAppliance(applianceRepo.findAll());
    }


    @Override
    public ApplianceDto updateAppliance(ApplianceDto appliance, Long id) {

        boolean existe =applianceRepo.existsById(id);
        if(existe){
           applianceMapper.ApplianceToApplianceDTO(applianceRepo.save(applianceMapper.ApplianceDTOToAppliance(appliance)));
        }

        return appliance;
    }


    @Override
    public void deleteAppliance(Long id) {
        applianceRepo.deleteById(id);
    }



}
