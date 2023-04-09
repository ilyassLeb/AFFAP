package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Type;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TypeApplianceRepo extends JpaRepository<Type,Long> {

  /*  @Query("SELECT t  FROM Type t JOINT t.Appliance a where t.appliance_id= a.type_app_id")
    List<Type> findTypeAppliance(Long id);

   */

}
