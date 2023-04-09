package com.appliance.AFAPP.controller;

import com.appliance.AFAPP.Model.Seance;
import com.appliance.AFAPP.dto.SeanceDto;
import com.appliance.AFAPP.services.ISeanceService;
import com.appliance.AFAPP.services.serviceimpl.SeanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SeanceController {
    @Autowired
    public ISeanceService seanceService;

    //liste de seance
    @GetMapping(path="Seance/seances")
    public List<SeanceDto> read() {
        return seanceService.findAll();
    }

    //add seance
    @PostMapping(path="Seance/addseance")
    public SeanceDto creer(@RequestBody SeanceDto seance){

        return seanceService.createSeance(seance);
    }

    //modification d'une seance
    @PutMapping(path="Seance/modifierseance/{id}")
    public SeanceDto modifierseance(@PathVariable Long id, @RequestBody SeanceDto seance){
        return seanceService.updateSeance(seance,id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "Seance/deleteseance/{id}")
    public void suppseance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
    }


}
