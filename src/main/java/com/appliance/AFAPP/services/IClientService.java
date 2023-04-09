package com.appliance.AFAPP.services;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Client;
import com.appliance.AFAPP.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IClientService {

    ClientDto createClient(ClientDto client);
    List<ClientDto> findAll();
    ClientDto updateClient(ClientDto client ,Long id);
    void deleteClient(Long id);
}
