package com.appliance.AFAPP.controller;


import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Pov;
import com.appliance.AFAPP.dto.PovDto;
import com.appliance.AFAPP.services.IPovService;
import com.appliance.AFAPP.services.serviceimpl.PovService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController

public class PovController {
    @Autowired
    public IPovService povService;

    //lister
    @GetMapping("Pov/povs")
    public List<PovDto> read() {
        return povService.findAll();
    }

    // add
    public PovDto creer(@RequestBody PovDto pov) {

        return povService.createPov(pov);
    }

    //modification d'un POV
    @PutMapping(path = "Pov/modifierpov/{id}")
    public PovDto modifier(@PathVariable Long id, @RequestBody PovDto pov) {
        return povService.updatePov(pov, id);
    }

    @PostMapping("/save")
    public PovDto save(PovDto povDto) {
        return povService.createPov(povDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "Pov/deletepov/{id}")
    public void suppov(@PathVariable Long id) {
        povService.deletepov(id);
    }
}