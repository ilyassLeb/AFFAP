package com.appliance.AFAPP.repo;


import com.appliance.AFAPP.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo  extends JpaRepository<Client,Long> {
}
