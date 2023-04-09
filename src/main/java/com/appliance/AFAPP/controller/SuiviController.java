package com.appliance.AFAPP.controller;

import com.appliance.AFAPP.Model.Suivi;
import com.appliance.AFAPP.dto.SuiviDto;
import com.appliance.AFAPP.services.ISuiviService;
import com.appliance.AFAPP.services.serviceimpl.SuiviService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SuiviController {
@Autowired
    public ISuiviService suiviService;

    //liste des suivis
    @GetMapping(path="/suivis")
    public List<SuiviDto> read(){
        return suiviService.findAll();
    }

    @PostMapping(path="/addsuivi")
    public SuiviDto creer(@RequestBody SuiviDto suivi ){

        return suiviService.createSuivi(suivi);
    }


    @PutMapping(path="/modifiersuivi/{id}")
    public SuiviDto modifiersuivi(@PathVariable Long id, @RequestBody SuiviDto suivi){
        return suiviService.updateSuivi(suivi,id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/deletesuivi/{id}")
    public void suppsuivi(@PathVariable Long id) {
        suiviService.deleteSuivi(id);
    }
}
