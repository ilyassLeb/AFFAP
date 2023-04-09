package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.TypePrestation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePrestationRepo extends JpaRepository<TypePrestation,Long> {
}
