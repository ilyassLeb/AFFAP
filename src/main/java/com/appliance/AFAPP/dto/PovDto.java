package com.appliance.AFAPP.dto;

import com.appliance.AFAPP.Model.Appliance;
import com.appliance.AFAPP.Model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PovDto {


    private Long id;
    private Date date_debut;
    private Date date_fin;

    private String description;

    private String dompte_Manager;

    private String ingenieurCyberSecurite;

    private String analyseurCyberSecurite;

    private String libelepov;

     private ApplianceDto dtoAppliance;
     private ClientDto dtoClient;


}
