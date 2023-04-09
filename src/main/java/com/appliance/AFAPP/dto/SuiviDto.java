package com.appliance.AFAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuiviDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean offre_commerciale;
    private Float mantant ;
    private PovDto dtoPov;
    private TypePrestationDto dtoTypePrestation;


}
