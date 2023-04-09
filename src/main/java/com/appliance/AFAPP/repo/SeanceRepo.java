package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepo  extends JpaRepository<Seance,Long> {
}
