package com.appliance.AFAPP.controller;


import com.appliance.AFAPP.dto.TypePrestationDto;
import com.appliance.AFAPP.repo.TypePrestationRepo;
import com.appliance.AFAPP.services.ITypePrestationService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class TypePrestationController {
    @Autowired
    public ITypePrestationService typePrestationService;
    @Autowired
    private TypePrestationRepo typePrestationRepo;

    public TypePrestationController(TypePrestationRepo typePrestationRepo) {
        this.typePrestationRepo = typePrestationRepo;
    }

    @GetMapping(path="TypePrestation/typesprestations")
    public List<TypePrestationDto> read(){
        return typePrestationService.findAll();
    }

    @PostMapping(path="type/addtypeprestation")
    public TypePrestationDto creer(@RequestBody TypePrestationDto typePrestation){

        return typePrestationService.createTypePrestation(typePrestation);
    }

    @PutMapping(path="/modifiertypeprestation/{id}")
    public TypePrestationDto modifiertypeprestation(@PathVariable Long id, @RequestBody TypePrestationDto typePrestation) {
        return typePrestationService.updateTypePrestation(typePrestation, id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/deletetypepres/{id}")
    public void supptypepres(@PathVariable Long id) {
        typePrestationService.deleteTypePrestation(id);
    }




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/pdftypeP")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typePrestationRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();


        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper Report/TypePrestation.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "TypePrestation.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=TypePrestation.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }
}
