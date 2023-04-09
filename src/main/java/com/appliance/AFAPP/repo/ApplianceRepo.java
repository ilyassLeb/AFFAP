package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

@CrossOrigin("http://localhost:4200/")
public interface ApplianceRepo extends JpaRepository<Appliance,Long> {


    @Query("SELECT t FROM Appliance t")
    List<Appliance> find();



}
