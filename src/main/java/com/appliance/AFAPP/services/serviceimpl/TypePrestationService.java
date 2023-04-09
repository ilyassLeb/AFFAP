package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.TypePrestation;
import com.appliance.AFAPP.dto.TypePrestationDto;
import com.appliance.AFAPP.mapping.TypePrestationMapper;
import com.appliance.AFAPP.repo.TypePrestationRepo;
import com.appliance.AFAPP.services.ITypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePrestationService implements ITypePrestationService {

    @Autowired
    TypePrestationMapper typePrestationMapper;


    @Autowired
     TypePrestationRepo typePrestationRepo;



    @Override
    public TypePrestationDto createTypePrestation(TypePrestationDto typePrestationDto) {
        return typePrestationMapper.typeptotypepdto(typePrestationRepo.save(typePrestationMapper.typepdtotypep(typePrestationDto))) ;
    }

    @Override
    public List<TypePrestationDto> findAll() {
        return   typePrestationMapper.listtypeprestationtypeprestationdto(typePrestationRepo.findAll());
    }

    @Override
    public TypePrestationDto updateTypePrestation(TypePrestationDto typePrestationDto, Long id) {
        return typePrestationRepo.findById(id)
                .map(p->{
                    p.setLibele(typePrestationDto.getLibele());

                    return   typePrestationMapper.typeptotypepdto(typePrestationRepo.save(p));

                }).orElseThrow(()->new RuntimeException("le type prestation  N'est pas trouvé "));
    }

    @Override
    public String deleteTypePrestation(Long id) {
        typePrestationRepo.deleteById(id);
        return "";
    }
}
