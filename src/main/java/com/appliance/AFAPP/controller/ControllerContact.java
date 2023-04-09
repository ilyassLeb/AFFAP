package com.appliance.AFAPP.controller;

import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.Model.Contact;
import com.appliance.AFAPP.dto.ContactDto;
import com.appliance.AFAPP.services.IContactService;
import com.appliance.AFAPP.services.serviceimpl.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/Contact")
public class ControllerContact {
    @Autowired
    public IContactService contactService;


//liste de contacts
@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/contacts")
    public List<ContactDto> read() {
        return contactService.findAll();
    }

//add contact
@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="Contact/addContact")
    public ContactDto creer(@RequestBody ContactDto contact){

        return contactService.createContact(contact);
    }

    @CrossOrigin(origins = "http://localhost:4200")
//modification d'un contact
    @PutMapping(path="Contact/modifiercontact/{id}")
    public ContactDto modifiercontact(@PathVariable Long id, @RequestBody ContactDto contact){
        return contactService.updateContact(contact,id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="Contact/deletecontact/{id}")
    public void suppcontact(@PathVariable Long id){
       contactService.deleteContact(id);
    }




}
