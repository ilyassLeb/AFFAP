package com.appliance.AFAPP.services.serviceimpl;


import com.appliance.AFAPP.Model.Type;
import com.appliance.AFAPP.dto.TypeDto;
import com.appliance.AFAPP.mapping.TypeMapper;
import com.appliance.AFAPP.repo.TypeApplianceRepo;
import com.appliance.AFAPP.services.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    TypeApplianceRepo typeApplianceRepo;

    @Override
    public TypeDto createType(TypeDto typedto) {

        return typeMapper.typetotypedto(typeApplianceRepo.save(typeMapper.typedtototype(typedto))) ;
    }

    @Override
    public List<TypeDto> findAll() {
       return typeMapper.ListEntitytypeToEntitytypedto(typeApplianceRepo.findAll());
    }

    @Override
    public TypeDto updateType(TypeDto type, Long id) {

        return typeApplianceRepo.findById(id)
             .map(p->{
                      p.setLibele(type.getLibele());

             return typeMapper.typetotypedto(typeApplianceRepo.save((p)));

                }).orElseThrow(()->new RuntimeException("le type prestation  N'est pas trouvé "));


    }

    @Override
    public String deleteType(Long id) {
        return null;
    }

  /*  @Override
    public List <Type> findType(Long id) {
        return typeApplianceRepo.findTypeAppliance(id);
    }

   */
}
