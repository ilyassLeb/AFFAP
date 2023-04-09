package com.appliance.AFAPP.controller;

import com.appliance.AFAPP.dto.TypeDto;
import com.appliance.AFAPP.repo.TypeApplianceRepo;
import com.appliance.AFAPP.services.ITypeService;
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
@CrossOrigin("*")
@RequestMapping("/Type")

public class TypeController {
    @Autowired
    public ITypeService typeService;
    @Autowired
    private TypeApplianceRepo typeApplianceRepo;


    @GetMapping(path="/types")
    public List<TypeDto> read(){
        return typeService.findAll();
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/addtype")
    public TypeDto creer(@RequestBody TypeDto type ){

        return typeService.createType(type);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path="/modifiertype/{id}")
    public TypeDto modifiertype(@PathVariable Long id, @RequestBody TypeDto type){
        return typeService.updateType(type ,id);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "Type/deletetype/{id}")
    public void supptype(@PathVariable Long id) {
        typeService.deleteType(id);
    }

/*@GetMapping(path="/afichertype/{id}")
    public List<Type>afficherType(@PathVariable Long id){
        return typeService.findType(id);

}
 */
//@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pdftypeapp")
    public ResponseEntity<byte[]>  downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typeApplianceRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();


        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper Report/Type.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "Type.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Type.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

}
