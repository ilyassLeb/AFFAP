package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.Model.Contact;
import com.appliance.AFAPP.dto.ContactDto;
import com.appliance.AFAPP.mapping.ContactMapper;
import com.appliance.AFAPP.repo.ContactRepo;
import com.appliance.AFAPP.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {
    @Autowired
     ContactRepo contactRepo;

   @Autowired
    ContactMapper contactMapper;


    @Override
    public ContactDto createContact(ContactDto contact) {
        return contactMapper.contacttocontactdto(contactRepo.save(contactMapper.contactdtocontact(contact)));
    }

    @Override
    public List<ContactDto> findAll() {
        return  contactMapper.listcontacttolistcontactdto(contactRepo.findAll()) ;
    }

    @Override
    public ContactDto updateContact(ContactDto contactDto, Long id) {

        boolean existe =contactRepo.existsById(id);
        if(existe){
            contactDto.setId(id);
            contactMapper.contacttocontactdto(contactRepo.save(contactMapper.contactdtocontact(contactDto)));
        }
        return contactDto;



       /* return contactRepo.findById(id)
                .map(p->{
                    p.setTelephone(contact.getTelephone());
                    p.setNom(contact.getNom());
                    p.setFonction(contact.getFonction());
                    p.setPrenom(contact.getPrenom());
                    p.setEmail(contact.getEmail());
                    p.setClient(contact.getClient());
                    return  contactMapper.contacttocontactdto(contactRepo.save(p));

                }).orElseThrow(()->new RuntimeException("CONTACT Non trouvé "));

        */
    }

    @Override
    public void deleteContact(Long id) {
        contactRepo.deleteById(id);

    }
}
