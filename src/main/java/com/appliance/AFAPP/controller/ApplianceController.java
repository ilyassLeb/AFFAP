package com.appliance.AFAPP.controller;

import com.appliance.AFAPP.dto.ApplianceDto;
import com.appliance.AFAPP.services.IApplianceService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import com.appliance.AFAPP.repo.ApplianceRepo;
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

@RequestMapping("/A")
public class ApplianceController {
    @Autowired
    private IApplianceService applianceService;

    @Autowired
     private ApplianceRepo applianceRepo;




    //@CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping(path="/find")
    public List<ApplianceDto> read(){
        return applianceService.findAll();
    }


   // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/addappliance")
    public ApplianceDto creer(@RequestBody ApplianceDto appliance){

        return applianceService.createAppliance(appliance);
    }


    @PutMapping(path="/modifierapp/{id}")
    public ApplianceDto modifierappliance(@PathVariable Long id, @RequestBody ApplianceDto appliance){
        return applianceService.updateAppliance(appliance,id);
    }


   // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pdfappliance")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(applianceRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();
        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper Report/Appliance.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "Type.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        System.err.println(data);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Type.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="/deleteappliance/{id}")
    public void suppappliance(@PathVariable Long id){
        applianceService.deleteAppliance(id);
    }




}
