package com.appliance.AFAPP.services.serviceimpl;

import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.dto.ClientDto;
import com.appliance.AFAPP.mapping.ClientMapper;
import com.appliance.AFAPP.repo.ClientRepo;
import com.appliance.AFAPP.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService implements IClientService {
    @Autowired
  ClientRepo clientRepo;
    @Autowired
    ClientMapper clientMapper;




    @Override
    public ClientDto createClient(ClientDto client) {
        return clientMapper.clientoclientdto(clientRepo.save(clientMapper.clientdtoclient(client)));
    }

    @Override
    public List<ClientDto> findAll() {
        return  clientMapper.listclienttolistclientdto(clientRepo.findAll()) ;
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, Long id) {

        boolean existe =clientRepo.existsById(id);
        if(existe){
            clientMapper.clientoclientdto(clientRepo.save(clientMapper.clientdtoclient(clientDto)));
        }

        return clientDto;

    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

}
