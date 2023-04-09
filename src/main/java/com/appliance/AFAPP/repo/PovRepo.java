package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Pov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PovRepo extends JpaRepository<Pov,Long> {
}
