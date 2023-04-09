package com.appliance.AFAPP.mapping;


import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.dto.ClientDto;
import org.dozer.DozerBeanMapper;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public ClientDto clientoclientdto (Client client){
     ClientDto clientDto=dozerBeanMapper.map(client,ClientDto.class);
        return clientDto;
    }

    public Client clientdtoclient(ClientDto clientDto){
        Client client=dozerBeanMapper.map(clientDto,Client.class);
        return client;
    }


    //listclientdtoclient
    public List<Client> listclientdtoclient(List<ClientDto> clientDtos){

        List<Client> listeclientdto=new ArrayList<>();

        clientDtos.forEach(ClientDto->listeclientdto.add(clientdtoclient(ClientDto)));

        return  listeclientdto;
    }

    // listclienttolistclientdto
    public List<ClientDto> listclienttolistclientdto(List<Client>clients){
        List<ClientDto>listclients=new ArrayList<>();
        clients.forEach(a->listclients.add(clientoclientdto(a) ));
        return listclients;
    }

}
