package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.Model.Contact;
import com.appliance.AFAPP.dto.ContactDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IContactService {

    ContactDto createContact(ContactDto contact);
    List<ContactDto> findAll();
    ContactDto updateContact(ContactDto contact ,Long id);

    void deleteContact(Long id);
}
