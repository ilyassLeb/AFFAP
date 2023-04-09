package com.appliance.AFAPP.dto;

import com.appliance.AFAPP.Model.Pov;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SeanceDto {


    private Long id ;
    private Date date_Seance;
    private String resume;
    private String participant ;
    private PovDto povDto;




}
