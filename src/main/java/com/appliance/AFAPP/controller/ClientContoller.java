package com.appliance.AFAPP.controller;
import com.appliance.AFAPP.dto.ClientDto;
import com.appliance.AFAPP.services.IClientService;
import com.appliance.AFAPP.services.serviceimpl.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/C")
public class ClientContoller {
    @Autowired
    public  IClientService clientService;
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="Client/addclient")
    public ClientDto creer(@RequestBody ClientDto client){

        return clientService.createClient(client);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/clients")
    public List<ClientDto> read() {
        return clientService.findAll();
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path="Client/updateclient/{id}")
   public ClientDto modifierclient( @RequestBody ClientDto client ,@PathVariable Long id) {
       return clientService.updateClient(client,id);
        }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="Client/delete/{id}")
    public void suppclient(@PathVariable Long id){
        clientService.deleteClient(id);
    }


}
