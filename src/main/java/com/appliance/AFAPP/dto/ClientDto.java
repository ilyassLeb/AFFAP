package com.appliance.AFAPP.dto;

import com.appliance.AFAPP.Model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id ;
    private String libele;
    private String secteur;
    private String activite ;
    //public List<Contact> Contact;
}
