package com.appliance.AFAPP.repo;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Long> {
}
