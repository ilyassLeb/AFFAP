package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuiviRepo extends JpaRepository<Suivi,Long> {
}
