package com.appliance.AFAPP.mapping;

import com.appliance.AFAPP.Model.Contact;
import com.appliance.AFAPP.dto.ContactDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ContactMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    ClientMapper clientMapper;
//contact to contact dto AND ID clientEntity TO idclientDTO
    public ContactDto contacttocontactdto (Contact contact){
        ContactDto contactDto=dozerBeanMapper.map(contact,ContactDto.class);
        if(contactDto.getClientDto()!=null){
            contactDto.setClientDto(clientMapper.clientoclientdto(contact.getClient()));
        }
        return contactDto;

    }
    //contactDTO TO contact AND idcontactDTO TO idcontact
    public Contact contactdtocontact (ContactDto contactDto){
        Contact contact =dozerBeanMapper.map(contactDto,Contact.class);
        if(contactDto.getClientDto()!=null){
            contact.setClient(clientMapper.clientdtoclient(contactDto.getClientDto()));
        }
        return contact;
    }

    public List<Contact> listcontactdtocontact(List<ContactDto> contactDtos){
        List<Contact> listecontactdto =new ArrayList<>();
        contactDtos.forEach(contactdto->listecontactdto.add(contactdtocontact(contactdto)));
        return listecontactdto;
    }
    public List<ContactDto> listcontacttolistcontactdto(List<Contact> contacts){
        List<ContactDto>listcontact=new ArrayList<>();
        contacts.forEach(contact->listcontact.add(contacttocontactdto(contact)));
        return listcontact;
    }

}
