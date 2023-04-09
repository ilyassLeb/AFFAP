package com.appliance.AFAPP.dto;

import com.appliance.AFAPP.Model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id ;
    private String nom;
    private String prenom;
    private String telephone ;
    private String fonction ;
    private String email;
    private ClientDto clientDto;

}
